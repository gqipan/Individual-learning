<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="emp_list">用户列表</a>
	<br />
	<br />
	<a href="userLogin">Test-i18N</a>
	<br />
	<br />
	<!-- 必須是 struts 請求,使得 i18 拦截器工作 -->
	<a href="userLogin.action?request_locale=en_US">English</a>
	<br />
	<a href="userLogin.action?request_locale=zh_CN">中文</a>
</body>
</html>