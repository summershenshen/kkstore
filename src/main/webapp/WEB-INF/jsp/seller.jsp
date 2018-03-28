<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>

<script type="text/javascript" language="javaScript">
	function del(url){
		if(confirm("确定删除该商品？")){
			window.location.href = "/goodsRemove"+url+".html";
		}
	document.form1.action("/goodsRemove"+url+".html");
}
</script>
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
	<td width="1000px" height="340px" align="center">
	<a href="/sellerGoodsDetail${goods.id}.html">
			<table bgcolor="#ffffff">
				<tr>
				<td align="center">
				<c:if test="${goods.alreadyBuy == 1}">
					<div style="position: relative; width: 230px; height: 200px;">
						<img src="${goods.image}" height="200px" width="230px" /> 
						<span style="position: absolute; top: 0; right: 0; color: #d6d6d6">已出售</span>
					</div>
				</c:if> 
				<c:if test="${goods.alreadyBuy == null}">
					<img src="${goods.image}" height="200px" width="230px" />
				</c:if>
				</td>
				</tr>
				<tr>
					<td height="40px" width="230px" style="font-size: 18px" align="center">
					${goods.name}</td>
				</tr>
				<tr>
					<td height="20px" width="230px" style="font-size: 20px;font-weight: bold; font-style: arial;" align="left">
					￥${goods.price}</td>
				</tr>
			</table>
		</a>	
	<table>
		<tr>
		<td height="20px" width="1000px" align="center">
			<c:if test="${goods.alreadyBuy == null}">
		<input type="button" style= "height:20px;width:30px bgcolor:#d4d4d4" name="删除" value="删除" onclick="del(${goods.id})"/>
	</c:if>
		</td>
		</tr>
	</table>
	</td>
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