<%-- 
    Document   : LaptopInformation
    Created on : Jul 10, 2021, 1:12:40 PM
    Author     : SE140866
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            rel="stylesheet" 
            href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
        >
        <link 
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" 
            rel="stylesheet"
        >
        <link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@500&family=Satisfy&display=swap" rel="stylesheet">
        <style><%@include file="\WEB-INF\statics\css\style.css"%></style>
        <title>Home Page</title>
    </head>
    <body>
        
        <%@include file="../common/Header.jsp" %>
        
       <div class="container">
           <div class="col-md-12 mt-4 p-3 border shadow">
               <h4 class="font-weight-bold">Laptop Form</h4>
                <form class="form-group" action="EmployeeEditServlet" method="POST">
                    <c:set var="obj" value="${requestScope.dto}"/>
                    <c:set var="objErr" value="${requestScope.dtoErr}"/>
                    
                    <input type="hidden" name="id" value="${param.elid}">
                    
                    <div class="row">
                        <div class="col-md-6">
                            <div class="mt-2">
                                <label for="name">Name:</label>
                                <input class="form-control" type="text" id="name" name="name" value="${param.name eq null ? obj.name : param.name}">
                                <font color="red">${objErr.nameError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="price">Price:</label>
                                <input class="form-control" type="number" step="0.1" id="price" name="price" value="${param.price eq null ? obj.price : param.price}">
                                <font color="red">${objErr.priceError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="cpu">CPU:</label>
                                <input class="form-control" type="text" name="cpu" id="cpu" value="${param.cpu eq null ? obj.CPU : param.cpu}">
                                <font color="red">${objErr.CPUError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="ram">Ram:</label>
                                <input class="form-control" type="text" id="ram" name="ram" value="${param.ram eq null ? obj.ram : param.ram}">
                                <font color="red">${objErr.ramError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="screen">Screen:</label>
                                <input class="form-control" type="text" id="screen" name="screen" value="${param.screen eq null ? obj.screen : param.screen}">
                                <font color="red">${objErr.screenError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="graphic">Graphic:</label>
                                <input class="form-control" type="text" id="graphic" name="graphic" value="${param.graphic eq null ? obj.graphic : param.graphic}">
                                <font color="red">${objErr.graphicError}</font>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="mt-2">
                                <label for="disk">Disk:</label>
                                <input class="form-control" type="text" id="disk" name="disk" value="${param.disk eq null ? obj.disk : param.disk}">
                                <font color="red">${objErr.diskError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="disk">OS:</label>
                                <input class="form-control" type="text" id="os" name="os" value="${param.os eq null ? obj.oS : param.os}">
                                <font color="red">${objErr.OSError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="weight">Weight:</label>
                                <input class="form-control" type="number" step="0.1" id="weight" name="weight" value="${param.weight eq null ? obj.weight : param.weight}">
                                <font color="red">${objErr.weightError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="region">Region:</label>
                                <input class="form-control" type="text" name="region" id="region" value="${param.region eq null ? obj.region : param.region}">
                                <font color="red">${objErr.regionError}</font>
                            </div>
                            <div class="mt-2">
                                <label for="year">Year:</label>
                                <input class="form-control" type="number" step="1" id="year" name="year" value="${param.year eq null ? obj.year : param.year}">
                                <font color="red">${objErr.yearError}</font>
                            </div>
                        </div>
                    </div>
                    <div class="mt-2 align-self-end px-3">
                        <div class="row">
                            <input class="btn btn-success mr-3" type="submit" name="btn" value="${param.elid eq 0 ? "Create" : "Edit"}">
                            <input class="btn btn-outline-success" type="reset" value="Reset">
                            <input type="hidden" name="elid" value="${param.elid eq null ? obj.id : param.elid}">
                        <div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
