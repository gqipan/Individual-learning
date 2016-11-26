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
	<s:debug></s:debug>
	
	<%-- <s:property value="exceptionStack"/> --%>
	<s:property value="exception"/>
	
	<h3>输入用户信息</h3>
	<form action="${pageContext.request.contextPath}/user_add" method="post">
		用户名 <input type="text" name="username" /> <br /><br />
		年龄 <input type="text" name="age" /><br /><br />
		住址 <input type="text" name="address" /> <br /><br />
		<input type="submit" value="添加用户" />
	</form>
</body>
</html>