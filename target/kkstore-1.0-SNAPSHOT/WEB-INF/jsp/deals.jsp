<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>
<style>
			.define-table{
				border-collapse:collapse;
				border-spacing:0;
				border-left:1px solid #888;
				border-top:1px solid #888;
				margin-left:20px;
				margin-top:20px;
			}
			.define-table th,.define-table td{
				border-right:1px solid #888;
				border-bottom:1px solid #888;
				padding:5px 15px;
			}
			.define-table th{
				font-weight:bold;background:#ccc;
			}	
		</style>
	<style>
			.define-table2{
				margin-left:20px;
				margin-top:20px;
			}
		</style>	
</head>

<body bgcolor="#f5f5f5">
	<jsp:include page="top.jsp" />	
	<table class="define-table" width="1000px" id="tab">
	<tr height="100px">
		<td width="200px" align="center">商品名称</td>
		<td width="200px" align="center">商品图片</td>
		<td width="200px" align="center">购买价格</td>
		<td width="200px" align="center">购买数量</td>
		<td width="200px" align="center">购买日期</td>
	</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach items="${dealsList}" var="deal">
			<tr height="150px">
				<td width="200px" align="center">${deal.name}</td>
				<td width="200px" align="center"><img src="${deal.image}"
					height="150px" width="200px" /></td>
				<td width="200px" align="center">${deal.price}</td>
				<td width="200px" align="center">${deal.num}</td>
				<td width="200px" align="center"><fmt:formatDate value="${deal.date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			</tr>
			<c:set value="${total +(deal.price*deal.num)}" var="total" />
		</c:forEach>
	</table>
	<table class="define-table2" width="1000px">
	<tr height="50px">
		<td width="200px"></td>
		<td width="200px"></td>
		<td width="200px"></td>
		<td width="200px" colspan=4 style="font-size: 20px; font-weight: bold; font-style: arial;"
			align="right">总价：</td>
         <td width="200px" style="font-size: 20px; font-weight: bold; font-style: arial;"
			align="left">￥${total}</td>
	</tr>
	</table>
</body>
</html>