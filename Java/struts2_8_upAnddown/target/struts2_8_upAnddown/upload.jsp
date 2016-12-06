<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>


    <s:fielderror name="photos"/>

    <s:form action="testUpload" enctype="multipart/form-data">
        <s:textfield name="userName[0]" label="用户-1"></s:textfield>
        <s:file name="photos" label="照片"></s:file>
        <s:textfield name="userName[1]" label="用户-2"></s:textfield>
        <s:file name="photos" label="照片"></s:file>
        <s:textfield name="userName[2]" label="用户-3"></s:textfield>
        <s:file name="photos" label="照片"></s:file>
        <s:submit value="提交"></s:submit>
    </s:form>

</body>
</html>
