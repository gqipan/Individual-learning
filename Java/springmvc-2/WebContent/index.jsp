<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		$(".testJson").click(function() {
			var url = $(this).attr("href");
			var args = ""
			$.ajax({
				type : "POST",
				url : url,
				success : function(data) {
					for (var i = 0; i < data.length; i++) {
						var id = data[i].id;
						var lastName = data[i].lastName;
						alert(id + " " + lastName)
					}
				}
			});
			return false;
		});
	});
</script>

<body>
	testInit:
	<a href="${pageContext.request.contextPath}/testInit">testInit</a>
	<hr>
	show all employees:
	<a href="${pageContext.request.contextPath}/testRestFul/emps">show
		all employees</a>
	<hr>
	testJson:
	<a class="testJson" href="${pageContext.request.contextPath}/testJson">testJson</a>
	
	<hr>
	testRequestBody:
	<br>
	<form action="${pageContext.request.contextPath}/testRequestBody" method="Post" enctype="multipart/form-data">
		File: <input type="file" name="file" value=""/><br/>
		PassWord: <input type="password" name="password" value=""/>
		Note: <input type="text" name="note" value=""/><br/>
		<input type="submit" value="TestRequestBody"/>	
	</form>
	<hr>
	<br>
	testResponseEntity: <a href="${pageContext.request.contextPath}/testResponseEntity">testResponseEntity</a>
	<hr>
	testHttpEntity:
	<br>
	<form action="${pageContext.request.contextPath}/testHttpEntity" method="Post" enctype="multipart/form-data">
		File: <input type="file" name="file" value=""/><br/>
		PassWord: <input type="password" name="password" value=""/>
		Note: <input type="text" name="note" value=""/><br/>
		<input type="submit" value="TestRequestBody"/>	
	</form>

	<hr>
	<br>
	testI18n: <a href="${pageContext.request.contextPath}/testI18n">testI18n</a>
</body>
</html>