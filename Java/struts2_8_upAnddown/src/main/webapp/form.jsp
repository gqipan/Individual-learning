<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Struts2 表单重复提交问题</title>
</head>
<body>

    <s:form action="testForm" >
        <!-- 增加token 标签,隐藏属性 -->
        <s:token></s:token>

        <s:textfield name="username" label="用户名"></s:textfield>
        <s:submit value="提交"></s:submit>
    </s:form>

</body>
</html>
