<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	${error}
	<form:form commandName="users" action="login_validate.html"
		methd="post">
		<table align="center" width="412" border="0">
			<tr>
				<td height="50px" width="100px"></td>
				<td></td>
			</tr>
			<tr>
				<td height="35px">用户ID：</td>
				<td><form:input id="id" path="id" /></td>
			</tr>
			<tr>
				<td height="35px">密码：</td>
				<td><form:password id="password" path="password" /></td>
			</tr>
			<tr>
				<td height="30px"></td>
				<td><input type="submit" value="确定">
			</tr>
		</table>
	</form:form>
</body>
</html>