<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
helloworld:<a href="${pageContext.request.contextPath}/helloworld">helloworld</a>
<hr>
testParams:<a href="${pageContext.request.contextPath}/testParams?age=27&tel=111">testParams</a>
<hr>
testHeaders:<a href="${pageContext.request.contextPath}/testHeaders">testHeaders</a>
<hr>
testAnt:<a href="${pageContext.request.contextPath}/testAnt/1/2/3/5">testAnt</a>
<hr>
testPathVariable:<a href="${pageContext.request.contextPath}/testPathVariable/719">testPathVariable</a>
<hr>
<fieldset>
RestFul Style:<br>
Post:<form action="${pageContext.request.contextPath}/order" method="post">
		<input type="submit" value="RestFul_Post">
	</form><br>
Delete:<form action="${pageContext.request.contextPath}/order/126" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="RestFul_Delete">
	</form><br>
Put:<form action="${pageContext.request.contextPath}/order/126" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="RestFul_Put">
	</form><br>
Get:<a href="${pageContext.request.contextPath}/order/126">RestFul_Get</a>
</fieldset>
<hr>
testRequestParam:<a href="${pageContext.request.contextPath}/testRequestParam?age=11&roldId=11&roldId=12&roldId=13">testRequestParam</a>
<hr>
testRequestHeader:<a href="${pageContext.request.contextPath}/testRequestHeader">testRequestHeader</a>
<hr>
testRequestHeaderHost:<a href="${pageContext.request.contextPath}/testRequestHeaderHost">testRequestHeaderHost</a>
<hr>
testCookieValue:<a href="${pageContext.request.contextPath}/testCookieValue">testCookieValue</a>
<hr>
testPOJO:<br>
	<form action="${pageContext.request.contextPath}/testPOJO" method="post">
		userName:<input type="text" name="userName" value="lisi"><br>
		passWord:<input type="password" name="passWord" value="123456"><br>
		age:	<input type="text" name="age" value="29"><br>
		email:	<input type="text" name="email" value="lisi@163.com"><br>
		<input type="submit" value="POJO_Commit">
	</form>
<hr>
testServletAPI:<a href="${pageContext.request.contextPath}/testServletAPI">testServletAPI</a>
<hr>
testModelAndView:<a href="${pageContext.request.contextPath}/testModelAndView">testModelAndView</a>
<hr>
testMap_Model_ModelMap:<a href="${pageContext.request.contextPath}/testMap_Model_ModelMap">testMap_Model_ModelMap</a>
<hr>
testSessionAttributes:<a href="${pageContext.request.contextPath}/testSessionAttributes">testSessionAttributes</a>
<hr>
testModelAttribute:<br>
	<form action="${pageContext.request.contextPath}/testModelAttribute" method="post">
		<input type="hidden" name="_method" value="PUT"><br>
		<input type="hidden" name="id" value="11"/><br>
		userName:<input type="text" name="userName" value="lisi"><br>
		age:<input type="text" name="age" value="26"><br>
		email:<input type="text" name="email" value="lisi@163.com"><br>
		<input type="submit" value="testModelAttribute_commit">
	</form>
<hr>
testJSTLView:<a href="${pageContext.request.contextPath}/testJSTLView">testJSTLView</a>
<hr>
testMyHelloView:<a href="${pageContext.request.contextPath}/testMyHelloView">testMyHelloView</a>
<hr>
testRedirect:<a href="${pageContext.request.contextPath}/testRedirect">testRedirect</a>
<hr>
testForward:<a href="${pageContext.request.contextPath}/testForward">testForward</a>	
</body>
</html>


