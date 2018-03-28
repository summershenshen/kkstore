<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>
<script type="text/javascript" language="javaScript">
	function del(url){
		if(confirm("确定从购物车移除该商品？")){
			window.location.href = "/cartRemove"+url+".html";
		}
	document.form1.action("/cartRemove"+url+".html");
}
</script>

<style>
.c {
	background-color: #ababab;
	font-size: 30px;
	font-weight: bord;
	face: arial;
	width: 120px;
	height: 40px;
	border: 5px;
	color: #ffffff;
	border-radius: 5px;
	margin-top:20px;
	margin-right:40px;
}

.c:hover {
	background-color: #ff6666;
}
</style>

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
	<table class="define-table" width="1000px">
	<tr height="100px">
		<td width="200px" align="center">商品名称</td>
		<td width="200px" align="center">商品图片</td>
		<td width="200px" align="center">购买价格</td>
		<td width="200px" align="center">购买数量</td>
		<td width="200px" align="center"></td>
	</tr>
		<c:forEach items="${cartGoodsList}" var="cartGoods">
			<tr height="150px">
				<td width="200px" align="center">${cartGoods.goods.name}</td>
				<td width="200px" align="center"><img src="${cartGoods.goods.image}"
					height="150px" width="200px" /></td>
				<td width="200px" align="center">${cartGoods.goods.price}</td>
				<td width="200px" align="center">${cartGoods.buyNum}</td>
				<td width="200px" align="center">
					<input type="button" style= "height:20px;width:30px bgcolor:#d4d4d4" name="删除该商品" value="删除该商品" onclick="del(${cartGoods.goods.id})"/>
			</tr>
		</c:forEach>
	</table>
	<table class="define-table2" width="1000px">
	<tr height="50px">
		<td width="200px"></td>
		<td width="200px"></td>
		<td width="200px"></td>
		<td width="200px"><a href="buyAllCartGoods.html"><input type="button" value="结算" class="c" /></a></td>
		<td width="200px"><a href="index.html"><input type="button" value="退出" class="c" /></a></td>
	</tr>
	</table>
</body>
</html>