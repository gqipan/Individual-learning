package com.pan.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 公共Mapper接口，定义常用方法
 *
 * @since  2016-02-02
 */
public interface BaseMapper<T> {

	/**
	 * 保存数据，过滤空的字段
	 * 
	 * @param t
	 *            实体对象
	 * @return int
	 * @throws
	 */
	int save(T t);

	/**
	 * 根据主键更新非空的字段
	 * 
	 * @param t
	 *            实体对象
	 * @return int
	 * @throws
	 */
	int update(T t);

	/**
	 * 根据主键查询表数据
	 * 
	 * @param id
	 *            主键
	 * @return T
	 * @throws
	 */
	T get(Serializable id);

	/**
	 * 批量保存数据，过滤空的字段
	 * 
	 * @param t
	 *            实体对象集
	 * @return int
	 * @throws
	 */
	int saveBatch(List<T> ts);

	/**
	 * 自定义查询
	 * 例如：
	 * 	1、orderShipmentMapper.customSelect("adjust_send_time", "number", shipmentNumber);
	 * 		执行的语句是：select adjust_send_time from order_shipment where number = ? 
	 * 	2、orderShipmentMapper.customSelect("adjust_send_time,remark", "number", shipmentNumber);
	 * 		执行的语句是：select adjust_send_time,remark from order_shipment where number = ?
	 * 
	 * @param
	 * @return HashMap<String,Object>
	 * @throws
	 */
	HashMap<String, Object> customSelect(@Param("outColumns") String outColumns,
			@Param("keyColumn") String keyColumn, @Param("keyValue") Object keyValue);
}
