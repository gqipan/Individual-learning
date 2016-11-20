<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

testHelloWorld: <a href="${pageContext.request.contextPath}/testHelloWorld">testHelloWorld</a>
<hr>
testRequestMapping：<a href="${pageContext.request.contextPath}/springmvc/testHelloWorld">testRequestMapping</a>
<hr>
testRequestMappingParams：<a href="${pageContext.request.contextPath}/springmvc/testRequestMappingParams?age=21&score=110">testRequestMappingParams</a>
<hr>
testRequestMappingHeaders：<a href="${pageContext.request.contextPath}/springmvc/testRequestMappingHeaders">testRequestMappingHeaders</a>
<hr>
testAnt:<a href="${pageContext.request.contextPath}/springmvc/testAntStyleXXYY/1/2/3/q">testAntStyle</a>
<hr>
testPathVariable:<a href="${pageContext.request.contextPath}/springmvc/testPathVariable/250/1000">testPathVariable</a>
</body>
</html>
