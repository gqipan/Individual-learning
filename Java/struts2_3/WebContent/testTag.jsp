<%@page import="org.pan.struts2.entities.CityComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.pan.struts2.entities.City"%>
<%@page import="java.util.List"%>
<%@page import="org.pan.struts2.entities.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Strut2的通用标签的测试页</h3>
	
	<!--s:debug标签可以在页面中直接显示对象栈和Map栈的信息  -->
	<s:debug></s:debug>
	
	<!--s:property可以直接获取到对象栈中对象的属性  -->
	<s:property value="username"/>
	
	<br /> <br />
	<!-- property可以获取到Map栈中的对象 -->
	<s:property value="#session.username"/>
	
	<br /> <br />
	<s:property value="#request.username"/>
	
	<br /> <br />
	<!-- parameters的结构map<String,String[]> 
		一般我们在使用parameters都需要加索引
	-->
	<s:property value="#parameters.age[0]"/>
	
	<br /> <br />
	
	<%	request.removeAttribute("username"); %>
	<!-- attr会从由小到大的属性从域中获取到属性：page request、值栈、session、application -->
	<!-- map栈中常用的对象 request session application parameters attr -->
	<s:property value="#attr.username"/>
	
	<br /> <br />
	
	<h3>url 标签</h3>
	<!--s:url标签用来创建一个完整的URL地址 -->
	<!-- 也可以将url放入到域中，通过var属性来指定属性名，然后就可以通过EL表达式使用URL地址 -->
	<s:url value="/index.jsp" var="indexURL"></s:url>
	${indexURL }
	
	<br /> <br />
	<!-- action可以指定要访问的目标action的name , namespace可以用来指定action的命名空间 -->
	<s:url action="user_add" namespace="/pan" var="addURL">
		<!-- value 如果是字符串 OGNL 会强制进行解析，所以可以用 '' -->
		<s:param name="username" value="'panpan'"></s:param>
		<s:param name="age" value="18"></s:param>
		<s:param name="gender" value="'male'"></s:param>
	</s:url>
	${addURL }
	
	<br /> <br />

	<h3>set 标签</h3>
	<!-- set标签用来向域中设置一个属性 -->
	<!-- value属性会自动被OGNL解析，指定要放入到域中的属性值 -->
	<!-- var指定要放入到域中的属性名 -->
	<!-- scope指定要放入到哪个域中 page request session application -->
	<!-- 默认会对value 进行OGNL 解析，所以使用 '' -->
	<s:set value="'testSetTagValue'" var="setTag" scope="request"></s:set>
	属性: ${request.setTag }


	<br /> <br />
	
	<h3>push 标签</h3>
	
	<%
		User user =  new User("这是使用push 标签压入栈顶的值");
		request.setAttribute("user", user);
	%>
	<s:push value="#request.user">
		push栈顶的值： ${username }<br>
	</s:push>
	出了push标签，栈顶对象就被弹出： <s:property value="#request.username"/>
	
	
	<br /> <br />
	
	<!-- if elseif else  -->
	<s:if test="#parameters.age[0]<14">
		<h3>你还是个小毛孩！</h3>
	</s:if>
	<s:elseif test="#parameters.age[0]<30">
		<h3>你是一个精壮的汉子！</h3>
	</s:elseif>
	<s:else>
		<h3>你已经是个老家伙了！</h3>
	</s:else>
	
	<br /> <br />
	
	<%
	
		List<City> cities = new ArrayList<City>();
		
		cities.add(new City(2,"上海"));
		cities.add(new City(3,"广州"));
		cities.add(new City(5,"东莞"));
		cities.add(new City(4,"深圳"));
		cities.add(new City(1,"北京"));
	
		request.setAttribute("cities", cities);
	%>
	
	<!-- s:iterator可以用来遍历一组集合 -->
	<!-- iterator标签会将集合中的每个元素，分别放入值栈的栈顶 -->
	<!-- status可以用来获取当前遍历的状态 -->
	<s:iterator value="#request.cities" status="st">
		${st } --  ${st.even }--${st.index} --${st.count } -- ${id } - ${name } <br />
	</s:iterator>
	
	
	<br /> <br />
	
	<s:iterator value="#request.cities" status="st">
		${id } - ${name } <br />
	</s:iterator>
	
	<br /> <br />
	<%
		CityComparator comparator = new CityComparator();
		request.setAttribute("comparator", comparator);
	%>
	<!-- sort标签可以用来给一个集合进行排序 -->
	<!-- comparator指定排序的类，source指定被排序的集合   var指定新集合的名字 -->
	<s:sort comparator="#request.comparator" source="#request.cities" var="cities_2"></s:sort>
	<s:iterator value="#attr.cities_2"  status="st">
		${id } - ${name } <br />
	</s:iterator>
	
	
	<br /> <br />
	<br /> <br />
	<br /> <br />
	
	
</body>
</html>