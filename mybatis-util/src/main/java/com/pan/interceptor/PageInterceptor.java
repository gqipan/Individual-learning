package com.pan.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pan.common.BaseQuery;

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 老规矩，签名里要拦截的类型只能是接口。
 * <p>usage:<br>
 * 	mybatis-config.xml配置pageSqlId属性指定哪些方法分页，默认是以Page结尾的方法<br>
 * 	目前的设定，方法入参是BaseQuery或BaseQuery的子类或者Map中设置key=query的类，这个类是BaseQuery或BaseQuery的子类<br>
 * </p>
 *
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor extends SqlSessionDaoSupport implements Interceptor {
	private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static String defaultDialect = "mysql"; // 数据库类型(默认为mysql)
	private static String defaultPageSqlId = ".*Page$"; // 需要拦截的ID(正则匹配)
	private static String dialect = ""; // 数据库类型(默认为mysql)
	private static String pageSqlId = ""; // 需要拦截的ID(正则匹配)
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
				DEFAULT_OBJECT_WRAPPER_FACTORY);
		// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
					DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY,
					DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
		dialect = configuration.getVariables().getProperty("dialect");
		if (null == dialect || "".equals(dialect)) {
			logger.warn("Property dialect is not setted,use default 'mysql' ");
			dialect = defaultDialect;
		}
		pageSqlId = configuration.getVariables().getProperty("pageSqlId");
		if (null == pageSqlId || "".equals(pageSqlId)) {
			logger.warn("Property pageSqlId is not setted,use default '.*Page$' ");
			pageSqlId = defaultPageSqlId;
		}
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
				.getValue("delegate.mappedStatement");
		// 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
		if (mappedStatement.getId().matches(pageSqlId)) {
			BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
			Object parameterObject = boundSql.getParameterObject();
			if (parameterObject == null) {
				throw new NullPointerException("parameterObject is null!");
			} else {
				Object paramObject = metaStatementHandler.getValue("delegate.boundSql.parameterObject");
				BaseQuery page = getBaseQuery(paramObject);
				String sql = boundSql.getSql();
				Connection connection = (Connection) invocation.getArgs()[0];
				// 重设分页参数里的总页数等
				setPageParameter(sql, connection, mappedStatement, boundSql, page, paramObject);
				// 重写sql
				String pageSql = buildPageSql(sql, page);
				metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
				// 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
				metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
				metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
			}
		}
		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}
	
	@SuppressWarnings("unchecked")
	public static BaseQuery getBaseQuery(Object paramObject){
		BaseQuery page = null;
		if (paramObject instanceof BaseQuery) {
			page = (BaseQuery)paramObject;
		}else if (paramObject instanceof Map) {
			page = (BaseQuery)((Map<String, Object>)paramObject).get("query");
			if (page == null) {
				Map<String, Object> parameterMap = ((Map<String, Object>)paramObject);
				for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
					Object valueObject = entry.getValue();
					if (valueObject instanceof BaseQuery) {
						page = (BaseQuery)valueObject;
						break;
					}
				}
			}
		}
		if (page == null) {
			throw new NullPointerException("page is null!");
		}
		return page;
	}

	/**
	 * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>BaseQuery</code>,这样调用者就可用通过 分页参数
	 * <code>BaseQuery</code>获得相关信息。
	 * 
	 * @param sql
	 * @param connection
	 * @param mappedStatement
	 * @param boundSql
	 * @param page
	 */
	private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
			BoundSql boundSql, BaseQuery page, Object paramObject) {
		// 记录总记录数
		String countSqlPrefix = "select count(0) as total ";
		int index = sql.indexOf("distinct");
		if (index > -1) {
			String alias = sql.substring(index + "distinct".length()).trim();
			alias = alias.substring(0, alias.indexOf(" "));
			countSqlPrefix = "select count(distinct " + alias + ") as total ";
		}else{
			index = sql.indexOf("DISTINCT");
			if (index > -1) {
				String alias = sql.substring(index + "DISTINCT".length()).trim();
				alias = alias.substring(0, alias.indexOf(" "));
				countSqlPrefix = "select count(distinct " + alias + ") as total ";
			}
		}
		
		index = sql.indexOf("order by");
		if (index > -1) {
			sql = sql.substring(0, index);
		}else {
			index = sql.indexOf("ORDER BY");
			if (index > -1) {
				sql = sql.substring(0, index);
			}
		}
		
		index = sql.indexOf("from");
		if (index > -1) {
			sql = sql.substring(index);
		}else{
			index = sql.indexOf("FROM");
			if (index > -1) {
				sql = sql.substring(index);
			}
		}

		String countSql = countSqlPrefix + sql;
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			BoundSql countBS = mappedStatement.getBoundSql(paramObject);
			setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
			rs = countStmt.executeQuery();
			int totalCount = 0;
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			page.setTotalRecord(totalCount);

		} catch (SQLException e) {
			logger.error("Ignore this exception", e);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
			try {
				countStmt.close();
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
		}
	}

	/**
	 * 对SQL参数(?)设值
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject,
				boundSql);
		parameterHandler.setParameters(ps);
	}

	/**
	 * 根据数据库类型，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String buildPageSql(String sql, BaseQuery page) {
		if (page != null) {
			StringBuilder pageSql = new StringBuilder();
			if ("mysql".equals(dialect)) {
				pageSql = buildPageSqlForMysql(sql, page);
			} else if ("oracle".equals(dialect)) {
				pageSql = buildPageSqlForOracle(sql, page);
			} else {
				return sql;
			}
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	/**
	 * mysql的分页语句
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	public StringBuilder buildPageSqlForMysql(String sql, BaseQuery page) {
		StringBuilder pageSql = new StringBuilder(100);
		int beginrow = page.getStartPosForMysql();
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPageSize());
		return pageSql;
	}

	/**
	 * 参考hibernate的实现完成oracle的分页
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	public StringBuilder buildPageSqlForOracle(String sql, BaseQuery page) {
		StringBuilder pageSql = new StringBuilder(100);
		int beginrow = page.getStartPos();
		String endrow = String.valueOf(page.getPageIndex() * page.getPageSize());

		pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
		pageSql.append(sql);
		pageSql.append(" ) temp where rownum <= ").append(endrow);
		pageSql.append(") where row_id > ").append(beginrow);
		return pageSql;
	}

	@Override
	public Object plugin(Object target) {
		// 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
