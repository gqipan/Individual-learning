<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h4><span style="color: red">${errorMsg}</span></h4>
    <label>userName: </label><input name="username" type="text" />
    <br/>
    <label>password: </label><input name="password" type="password" />
    <br/>
    <input type="submit"/>
</form>
</body>
</html>
