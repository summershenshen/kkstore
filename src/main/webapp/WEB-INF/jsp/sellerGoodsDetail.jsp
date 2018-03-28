<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>
<style>
.b {
	background-color: #ff6666;
	font-size: 30px;
	font-weight: bord;
	face: arial;
	width: 180px;
	height: 60px;
	border: 10px;
	color: #000000;
	border-radius: 5px;
}

.b:hover {
	background-color: #ff6633;
}
</style>
<style>
.c {
	background-color: #ababab;
	font-size: 30px;
	font-weight: bord;
	face: arial;
	width: 180px;
	height: 60px;
	border: 10px;
	color: #000000;
	border-radius: 5px;
}

.c:hover {
	background-color: #ababab;
}
</style>
</head>

<body>
	<jsp:include page="top.jsp" />
	<form action="edit${goods.id}.html">
		<table style="word-wrap: break-word; word-break: break-all" border="0">
			<tr height="300px">
				<td width="500px" align="center"><img src="${goods.image}"
					width="300px" height="300px" /></td>
				<td align="left">
					<table>
						<tr height="60px">
							<td width="600px"><font
								style="font-weight: bold; font-style: arial; font-size: 30px">${goods.name}</font></td>
						</tr>
						<tr height="60px">
							<td width="600px"><font size=5>${goods.abstract1}</font></td>
						</tr>
						<tr height="60px">
							<td width="200px"><font size=5>${goods.price}</font></td>
							<td width="200px"><font size=5>库存${goods.store}件</font></td>
							<td width="200px"></td>
						</tr>
						<tr height="100px">
							<td width="300px" style="font-weight: 900"><input
								type="submit" value="编辑" class="b" /></td>

						</tr>
					</table>
				</td>

			</tr>
			<tr style="background: #E5E5E5; height: 1px; width: 1100px">
				<td height="1px;"></td>
			</tr>
			<tr>
				<td align="left">${goods.introduction}</td>
			</tr>

		</table>
	</form>
</body>
</html>

