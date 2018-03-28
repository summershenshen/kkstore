<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            a{
                text-decoration:none;
            }
            #dive a:hover{
                text-decoration:#000000;
                background-color:#ff6666;
            }
            a:hover{
                color:#ff6a6a
            }
        </style>
    </head>
    <body>
        <div id="dive"  style="background-color:#ffc0cb;height: 30px;font-size: 18px;color:#000000"><p>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${sessionScope.id==null}" >
                    欢迎你！游客&nbsp;&nbsp;
                    <a href="login.html"  style="font-size: 15px;color:#000000">请登录</a>
                </c:if>
                <c:if test="${sessionScope.id eq 'seller' }"> 
                     欢迎你！卖家${sessionScope.id}&nbsp;&nbsp;
                    <a href="loginExit.html"  style="font-size: 15px;color:#000000">退出</a>
                </c:if>
                <c:if test="${sessionScope.id eq 'buyer' }"> 
                     欢迎你！买家${sessionScope.id}&nbsp;&nbsp;
                    <a href="loginExit.html"  style="font-size: 15px;color:#000000">退出</a>
                </c:if>
                
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <c:if test="${sessionScope.id eq 'seller' }"> 
                     <a href="seller.html" style="color:#000000;font-size: 20px;" >首页</a>&nbsp;
                     <a href="addNewGoods.html" style="color:#000000;font-size: 20px;">发布</a>&nbsp;
                </c:if>
                <c:if test="${sessionScope.id eq 'buyer' }"> 
                     <a href="buyer.html" style="color:#000000;font-size: 20px;" >首页</a>&nbsp;
                     &nbsp;<a href="shoppingcart.html"style="color:#000000;font-size: 20px;">购物车</a>&nbsp;
                     &nbsp;<a href="deals.html"style="color:#000000;font-size: 20px;">财务</a>&nbsp;               
                </c:if>
                <c:if test="${sessionScope.id == null }"> 
                		<a href="index.html" style="color:#000000;font-size: 20px;" >首页</a>&nbsp;
                     &nbsp;<a href="shoppingcart.html"style="color:#000000;font-size: 20px;">购物车</a>&nbsp;
                     &nbsp;<a href="deals.html"style="color:#000000;font-size: 20px;">财务</a>&nbsp;               
                </c:if>
        </div>
</body>
</html>
