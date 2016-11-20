<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello: Pan Pan<br>
<hr>
ModelAndView_test:${requestScope.mykey}<br>
<hr>
m1:${requestScope.m1}<br>
m2:${requestScope.m2}<br>
m3:${requestScope.m3}<br>
<hr>
sessionUser:${sessionScope.user}<br>
sessionSubway:${sessionScope.subway}<br>
<hr>
username:<fmt:message key="i18n.username"></fmt:message><br>
password:<fmt:message key="i18n.password"></fmt:message><br>
</body>
</html>