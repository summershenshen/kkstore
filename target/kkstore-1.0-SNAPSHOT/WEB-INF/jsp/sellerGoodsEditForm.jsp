<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>
</head>

<body>
	<jsp:include page="top.jsp" />
	${error}
	<form:form commandName="goods" action="editResult.html" methd="post"
		enctype="multipart/form-data">
		<table align="center" width="412" border="1">
			<tr>
				<td>商品id:</td>
				<td><form:input id="id" path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>标题:</td>
				<td><form:input id="name" path="name" /></td>
			</tr>
			<tr>
				<td>摘要:</td>
				<td><form:input id="abstract" path="abstract1" /></td>
			</tr>
			<tr>
				<td>正文:</td>
				<td><form:input id="introduction" path="introduction" /></td>
			</tr>
			<tr>
				<td>价格:</td>
				<td><form:input id="price" path="price" /></td>
			</tr>
			<tr>
				<td>库存量:</td>
				<td><form:input id="store" path="store" /></td>
			</tr>
			<tr>
				<td>图片:</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="确定"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>