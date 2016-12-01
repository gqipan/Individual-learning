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
	
	<table align="center" border="1" width="60%">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>部门</td>
			<td>职位</td>
			<td colspan="2">操作</td>
		</tr>
		<s:iterator value="#request.list">
			<tr>
				<td>${id }</td>
				<td>${name }</td>
				<td>${age }</td>
				<td>${dept }</td>
				<td>${role }</td>
				<td><a href="emp_del?id=${id}">删除</a></td>
				<td><a href="emp_input?id=${id}">修改</a></td>
			</tr>
		</s:iterator>
	</table>
	
	<hr />
	
	<s:form action="emp_add">
		<s:textfield name="name" label="姓名"></s:textfield>
		<s:textfield name="age" label="年龄"></s:textfield>
		<s:textfield name="dept" label="部门"></s:textfield>
		<s:textfield name="role" label="职务"></s:textfield>
		<s:textfield name="birth" label="生日"></s:textfield>
		<s:submit value="添加"></s:submit>
	</s:form>

</body>
</html>