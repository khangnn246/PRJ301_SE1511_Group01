<%-- 
    Document   : UserViewDetail
    Created on : Jul 5, 2021, 11:46:49 PM
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
        
        <c:set var="dto" value="${requestScope.Laptop}"/>
        <c:url var="urlRewriting" value="UserListServlet">
            <c:param name="txtlaptopname" value="${requestScope.lastSearchName}"/>
            <c:param name="txtminprice" value="${requestScope.lastSearchMinPrice}"/>
            <c:param name="txtmaxprice" value="${requestScope.lastSearchMaxPrice}"/>
            <c:param name="txtminyear" value="${requestScope.lastSearchMinYear}"/>
            <c:param name="txtmaxyear" value="${requestScope.lastSearchMaxYear}"/>
            <c:param name="btn" value="${requestScope.btn}"/>
        </c:url>
        
        <div class="container d-flex justify-content-center">
            <div class="col-md-10 my-4 border shadow p-3">
                <h3 class="font-weight-bold mb-3">Laptop Detail Information</h3>
                <div class="p-3 row">
                    <div class="col-md-6">
                        <p>
                            <strong>Id :</strong> ${dto.id}
                        </p>
                        <p>
                            <strong>Name :</strong> ${dto.name}
                        </p>
                        <p>
                            <strong>CPU :</strong> ${dto.CPU}
                        </p>
                        <p>
                            <strong>Ram :</strong> ${dto.ram}
                        </p>
                        <p>
                            <strong>Screen :</strong> ${dto.screen}
                        </p>
                        <p>
                            <strong>Graphic :</strong> ${dto.graphic}
                        </p>
                    </div>
                    <div class="col-md-6">
                        <p>
                            <strong>Disk :</strong> ${dto.disk}
                        </p>
                        <p>
                            <strong>OS :</strong> ${dto.oS}
                        </p>
                        <p>
                            <strong>Weight :</strong> ${dto.weight}
                        </p>
                        <p>
                            <strong>Region :</strong> ${dto.region}
                        </p>
                        <p>
                            <strong>Year :</strong> ${dto.year}
                        </p>
                        <p class="font-weight-bold">
                            Price : <fmt:formatNumber value="${dto.price}" maxFractionDigits="3"/> $
                        </p>
                    </div>
                </div>
                
                <form action="UserAddItemToCart">
                    <input type="hidden" value="${dto.id}" name="txtLaptopId" />
                    <input class="btn btn-info" type="submit" value="Add To Cart" name="btn" />
                </form>
            </div>
        </div>
    </body>
</html>
