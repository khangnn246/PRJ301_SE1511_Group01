<%-- 
    Document   : UserViewHistoryOrder
    Created on : Jul 10, 2021, 8:10:30 PM
    Author     : khang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link 
            rel="stylesheet" 
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
            integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
            crossorigin="anonymous"
        >
        <link 
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" 
            rel="stylesheet"
        >
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
            integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
            crossorigin="anonymous" referrerpolicy="no-referrer"
        >
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Satisfy&display=swap" rel="stylesheet">
        <style><%@include file="\WEB-INF\statics\css\style.css"%></style>
        <title>User Page</title>
    </head>
    <body>
        
        <%@include file="../common/Header.jsp" %>
        
        <div class="container d-flex justify-content-center">
            <div class="my-4 col-md-12 border shadow p-3">
                <h3 class="font-weight-bold mb-3">Your History Order</h3>
                <c:set var="listorder" value="${requestScope.OrderList}"/>
                <c:if test="${not empty listorder}">
                    <table class="table border">
                        <thead class="thead-light">
                            <tr>
                                <th>Order Id</th>
                                <th>Address</th>
                                <th>Total Price</th>
                                <th>Detail</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="order" items="${listorder}">
                            <tr>
                                <td>
                                    ${order.orderid}
                                </td>
                                <td>
                                    ${order.address}
                                </td>
                                <td>
                                    <fmt:formatNumber value="${order.totalprice}" maxFractionDigits="3"/>
                                </td>
                                <td>
                                    <a href="UserViewDetailCartServlet?id=${order.orderid}">View Detail</a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>        
                </c:if>
                <c:if test="${empty listorder}">
                    <h4>
                        You Haven't Maked Any Order
                    </h4>
                </c:if>
            </div>
        </div>
    </body>
</html>
