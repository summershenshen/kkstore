<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>kk store</title>

<style type="text/css">
	/*设置内容的基本属性*/
	#content{
		border-left:1px solid #d4d4d4; /*添加左边框*/
		border-right:1px solid #d4d4d4; /*添加右边框*/
		border-bottom:1px solid #d4d4d4; /*添加底部边框*/
		padding:15px;/*内容距离边界的空隙*/
		font-size:17px;/*字号*/
		}
	 /*设置无序列表的基本样式*/
	 ul#tabul{
		 list-style:none;/*去除无序列表前的点*/
		 margin:0px;
		 padding-left:20px;
		 padding-bottom:28px;
		 font:bold 17px Arial, Helvetica, sans-serif;/*定义字体*/
		 border-bottom:1px solid #d4d4d4;
		 }
	/*设置无序列表元素的基本样式*/
	ul#tabul li{
		float:left;/*向左浮动*/
		height:27px;
		margin:0px 4px 0px 0px;
		border:1px solid #d4d4d4;
		background:#d4d4d4;
		}
	/*设置链接以及访问过的样式*/
	ul#tabul a:link,ul#tabul a:visited{
		display:block;/*设置列表元素块状显示*/
		background:#ffffff;
		color:#000000;
		text-decoration:none;/*去掉下划线*/
		padding:5px 10px 3px 10px;
		}	
	/*设置鼠标经过时的样式*/
	ul#tabul a:hover{
		background:#ffffff;
		color:000000;
		}
		
    body#allList li.allList,body#notBuy li.notBuy{/*重定义列表菜单*/
    border-bottom:1px solid #ffffff;/*给块状菜单重新定义白色的下边框，起到覆盖原先定义的蓝色下边框*/
	color:#000000;
	background-color:#ffffff;
	
	/*以下css代码为激活时菜单的超链接效果*/
	body#allList li.allList a:link,body#allList li.allList a:visited,
	body#notBuy li.notBuy a:link,body#notBuy li.notBuy a:visited{color:#000000;}
	
	body#allList li.allList a:hover,
	body#notBuy li.notBuy a:hover{color:#0000cc;text-decoration:underline;}
</style>

</head>
<body bgcolor="#f5f5f5">
	<jsp:include page="top.jsp" />
<table>
	<tr height="20px">
		<td width="1000px"></td>
	</tr>
</table>
	<ul id="tabul">
    		<li class="allList"><a href="buyer.html">全部商品</a></li>
        <li class="notBuy"><a href="buyerType=1.html">未购买商品</a></li>
    </ul>
<table>
	<tr height="10px">
		<td width="1000px"></td>
	</tr>
</table>
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
				<td width="1000px" height="320px" align="center"><a
					href="/buyerGoodsDetail${goods.id}.html">
						<table bgcolor="#ffffff">
							<tr>
								<td align="center"><c:if test="${goods.alreadyBuy == 1}">
										<div style="position: relative; width: 230px; height: 200px;">
											<img src="${goods.image}" height="200px" width="230px" /> <span
												style="position: absolute; top: 0; right: 0; color: #9999ff">已购买</span>
										</div>
									</c:if> <c:if test="${goods.alreadyBuy == null}">
										<img src="${goods.image}" height="200px" width="230px" />
									</c:if></td>
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