<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>
</head>
<body bgcolor="#f5f5f5">
	<jsp:include page="top.jsp" />
	<table>
		<%
			int i = 1;
		%>
		<c:forEach items="${goodsList}" var="goods">
			<%
				if (i % 4 == 1) {
			%>
			<tr>
				<%
					}
				%>
				<td width="1000px" height="320px" align="center">
				<a href="/buyerGoodsDetail${goods.id}.html">
						<table bgcolor="#ffffff">
							<tr>
								<td align="center">
								<img src="${goods.image}" height="200px" width="230px" />
								</td>
							</tr>
							<tr>
								<td height="40px" width="230px" style="font-size: 18px"
									align="center">${goods.name}</td>
							</tr>
							<tr>
								<td height="20px" width="230px"
									style="font-size: 20px; font-weight: bold; font-style: arial;"
									align="left">￥${goods.price}</td>

							</tr>
						</table>
				</a></td>
				<%
					if (i % 4 == 0) {
				%>
			</tr>
			<%
				}
					i++;
			%>
		</c:forEach>
	</table>
</body>
</html>