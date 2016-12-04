<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h2>注册</h2>

<s:debug></s:debug>

<s:form action="user_register" method="POST" theme="simple">
    <s:label>用户名</s:label><s:textfield name="userName" label="用户名"></s:textfield>

        <span style="color: red">
                ${fieldErrors['user.userName'][0] }
        </span>
    <br/><br/>
    <s:label>年龄</s:label> <s:textfield name="age" label="年龄"></s:textfield>
        <span style="color: red">
                ${fieldErrors['user.age'][0] }
        </span>
    <br/><br/>
    <s:label>密码</s:label> <s:password name="password" label="密码"></s:password>
        <span style="color: red">
                ${fieldErrors['user.password'][0] }
        </span>
    <br/><br/>
    <s:submit name="submit" value="提交"></s:submit>
</s:form>

</body>
</html>
