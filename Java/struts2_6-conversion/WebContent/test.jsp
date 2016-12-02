<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 如果是配置了页面国际化资源文件，
	那么国际的内容只能在i18n标签中使用，一旦离开i18n标签则不能使用 -->
	<s:i18n name="i18n">

	</s:i18n>

	<h1>
		<s:text name="login"></s:text>
	</h1>
	<h3>
		<s:text name="info">
			<s:param>大师兄</s:param>
			<s:param>小师兄</s:param>
		</s:text>
	</h3>
	<s:form>
		<s:textfield name="username" key="username"></s:textfield>
		<s:password name="password" key="password"></s:password>
		<s:submit key="login"></s:submit>
	</s:form>
	
	<a href="test.action?request_locale=zh_CN">中文</a>|<a href="test.action?request_locale=en_US">ENGLISH</a>

</body>
</html>