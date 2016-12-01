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
	<s:form action="emp_update" theme="simple">
		<s:hidden name="id"></s:hidden>
		姓名：<s:textfield name="name" label="姓名"></s:textfield> <br>
		年龄：<s:textfield name="age" label="年龄"></s:textfield> <span style="color:red"><s:fielderror fieldName="age"></s:fielderror></span><br>
		部门: <s:textfield name="dept" label="部门"></s:textfield><br>
		职务：<s:textfield name="role" label="职务"></s:textfield><br>
		<s:submit value="修改"></s:submit>
	</s:form>
	
	
</body>
</html>