<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<%
		request.setAttribute("username", "requestSetUsername");
	%>

<body>
    <s:debug></s:debug>

    <hr><br><br>


<!-- OGNL 访问Map类型属性 -->
<%
    Map<String,String> letters = new HashMap<String,String>();
    letters.put("AA", "aa");
    letters.put("BB", "bb");
    letters.put("CC", "cc");
    request.setAttribute("letters", letters);
%>
isEmpty: <s:property value="#request.letters.isEmpty"></s:property><br><br>
size:<s:property value="#attr.letters.size()"/><br><br/>
AA:<s:property value="#attr.letters['AA']"/>


    <hr><br><br>

<%
    List<String> colors = new ArrayList<String>();
    colors.add("Red");
    colors.add("Black");
    colors.add("Green");

    request.setAttribute("colors", colors);
%>
isEmpty: <s:property value="#request.colors.isEmpty()"></s:property><br><br>
size: <s:property value="#request.colors.size"></s:property><br><br>
colors: <s:property value="#request.colors[1]"></s:property>

    <hr><br><br>

    <!-- OGNL 访问数组类型的属性 -->
    <%
        String[] names = new String[]{"aa","bb","cc","dd"};
        request.setAttribute("names", names);
    %>
    length:<s:property value="#attr.names.length"/>
    <br/>
    names[1]:<s:property value="#attr.names[1]"/>
    <hr><br><br>


    <!-- 调用栈顶对象的 公共方法和属性（属性就是我们之前访问的字段值） -->
    调用公共方法: <s:property value="sayYou('巨无霸')"></s:property>

    <hr><br><br>

    <!-- 调用静态方法和字段 -->
    调用静态字段: <s:property value="@java.util.Calendar@WEEK_OF_YEAR"></s:property><br>
    <!-- 对于调用静态方法，我们需要去 struts.xml 文件中配置-->
    调用静态方法: <s:property value="@org.pan.struts2.entity.User@sayHello('张三丰')"></s:property>


    <hr><br><br>

    <%
        session.setAttribute("hello", "你好");

        application.setAttribute("key", "appKey");

        session.setAttribute("key", "sessKey");

        request.setAttribute("key", "reqKey");
    %>
    <hr><br><br>
    <!-- Map栈中Session数据 -->
    获取到Session域中属性： <s:property value="#session.hello"></s:property><br><br>
    获取请求参数： <s:property value="#parameters.username"></s:property><br><br>
    <!-- attr 会从小到大的范围去查找 -->
    通过attr获取属性值：<s:property value="#attr.key"/>
    <hr><br><br>

    <!-- 直接获取Map栈中的属性 -->
    <s:property value="#request.username"></s:property>
    <br>

	<h3>添加成功</h3>
    <!-- 可以直接获取栈顶对象的属性，如果栈顶对象没有就会继续往下找，再没有就从Map栈中找 -->
    用户名 : <s:property value="user.username"></s:property> <br /> <br />
	年龄 : <s:property value="age"></s:property> <br /> <br />
	地址 : <s:property value="address"></s:property> <br /> <br />

    <hr>
    <!-- 对于被我们改变的栈顶对象，我们可以用下标的方式 -->
    用户名 : <s:property value="[1].username"></s:property> <br /> <br />
    地址 : <s:property value="[1].address"></s:property> <br /> <br />

    <hr>
    <!-- 另外两种方式 object['filedName'] 或者 object["filedName"] -->
    用户名 : <s:property value="[1]['username']"></s:property> <br /> <br />
    地址 : <s:property value="[1]['address']"></s:property> <br /> <br />

    <hr><br>

</body>
</html>