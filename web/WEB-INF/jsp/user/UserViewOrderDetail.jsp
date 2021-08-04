<%-- 
    Document   : UserViewCartDetail
    Created on : Jul 10, 2021, 11:09:09 PM
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
            <div class="col-md-12 my-4 border shadow p-3">
                <h3 class="font-weight-bold mb-3">Order Detail</h3>
                <c:set var="orderDetail" value="${requestScope.OrderDetailList}"/>
                <c:if test="${not empty orderDetail}">
                    <table class="table border">
                        <thead class="thead-light">
                            <tr>
                                <th>Order Detail Id</th>
                                <th>Laptop Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="orderDetails" items="${requestScope.OrderDetailList}">
                            <tr>
                                <td>
                                    ${orderDetails.orderDetailId}
                                </td>
                                <td>
                                    ${orderDetails.laptop.name}
                                </td>
                                <td>
                                    ${orderDetails.quantity}
                                </td>
                                <td>
                                    <fmt:formatNumber value="${orderDetails.laptop.price}" maxFractionDigits="3"/>
                                </td>
                            </tr>
                            </c:forEach>
                            <tr>
                                <td>
                                    Delivery Address :
                                </td>
                                <td colspan="3">
                                    ${orderDetail[0].order.address}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Phone :
                                </td>
                                <td colspan="3">
                                    ${sessionScope.USER.phone}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Full name :
                                </td>
                                <td colspan="3">
                                    ${sessionScope.USER.name}
                                </td>
                            </tr>
                            <tr>
                                <td class="font-weight-bold">
                                    Total Price :
                                </td>
                                <td colspan="3">
                                    <fmt:formatNumber value="${requestScope.totalprice}" maxFractionDigits="3"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                </c:if>
            </div>
        </div>
    </body>
</html>
