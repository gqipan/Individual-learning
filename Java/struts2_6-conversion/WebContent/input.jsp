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
	<s:form action="user_add">
		<s:textfield name="user.name" label="姓名"></s:textfield>
		<s:textfield name="user.gender" label="性别"></s:textfield>
		<s:textfield name="user.address" label="地址"></s:textfield>
		<s:textfield name="user.mgr.name" label="经理名称"></s:textfield>
		<s:textfield name="user.mgr.birth" label="经理生日"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>
	
	<hr />
	<s:form action="user_adds">
		<s:textfield name="users[0].name" label="姓名"></s:textfield>
		<s:textfield name="users[0].gender" label="性别"></s:textfield>
		<s:textfield name="users[0].address" label="地址"></s:textfield>
		
		<s:textfield name="users[1].name" label="姓名"></s:textfield>
		<s:textfield name="users[1].gender" label="性别"></s:textfield>
		<s:textfield name="users[1].address" label="地址"></s:textfield>
		
		
		<s:textfield name="users[2].name" label="姓名"></s:textfield>
		<s:textfield name="users[2].gender" label="性别"></s:textfield>
		<s:textfield name="users[2].address" label="地址"></s:textfield>
		
		
		<s:textfield name="users[3].name" label="姓名"></s:textfield>
		<s:textfield name="users[3].gender" label="性别"></s:textfield>
		<s:textfield name="users[3].address" label="地址"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>


	
	
</body>
</html>