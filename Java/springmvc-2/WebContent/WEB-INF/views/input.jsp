<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 后台需要new Emtity,然后jsp 的 modelAttribute添加同名标签，主要用于 binding -->
	<form:form action="${pageContext.request.contextPath}/testRestFul/emp" method="post" modelAttribute="employee">
		lastName: <form:input path="lastName"/>
				  <span style="color: red;"><form:errors path="lastName"/></span> 
				 <br/>
		email: <form:input path="email"/> 
				 <span style="color: red;"><form:errors path="email"/></span><br/>
		<!-- Radio 不需要设置 itemLabel，和 ItemValue -->
		gender:<form:radiobuttons path="gender" items="${requestScope.genders }"/> <form:errors path="gender"></form:errors> <br/>
		birth:<form:input path="birth"/> 
				 <span style="color: red;"><form:errors path="birth"/></span> <br/>
		department:<form:select path="department.id" items="${requestScope.departments }" itemLabel="departmentName" itemValue="id"></form:select> <br/>
		<input type="submit" value="sumbitEmployee"/>
	</form:form>
	
	<hr><br/><br/><br/><br/>
	<!-- Test 自定义类型转化器 -->
	<form action="${pageContext.request.contextPath}/testRestFul/empConvert" method="post">
		<input type="text" name="employee" value="li4;li4@163.com;1;105"/><br>
		<input type="submit" value="empConvert_commit">
	</form>
	
	
</body>
</html>