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
        <title>Employee Management</title>
    </head>
    <body>
        <h1>Laptop Form</h1>
        <form action="EmployeeEditServlet" method="POST">
            <c:set var="obj" value="${requestScope.dto}"/>
            <c:set var="objErr" value="${requestScope.dtoErr}"/>
            
            <input type="hidden" name="id" value="${param.elid}"></br>
            Name:<input type="text" name="name" value="${param.name eq null ? obj.name : param.name}">
            ${objErr.nameError}</br>
            
            Price:<input type="number" step="0.1" name="price" value="${param.price eq null ? obj.price : param.price}">
            ${objErr.priceError}</br>
            CPU:<input type="text" name="cpu" value="${param.cpu eq null ? obj.CPU : param.cpu}">
            ${objErr.CPUError}</br>
            
            Ram:<input type="text" name="ram" value="${param.ram eq null ? obj.ram : param.ram}">
            ${objErr.ramError}</br>
            Screen:<input type="text" name="screen" value="${param.screen eq null ? obj.screen : param.screen}">
            ${objErr.screenError}</br>
            
            Graphic:<input type="text" name="graphic" value="${param.graphic eq null ? obj.graphic : param.graphic}">
            ${objErr.graphicError}</br>
            Disk:<input type="text" name="disk" value="${param.disk eq null ? obj.disk : param.disk}">
            ${objErr.diskError}</br>
            
            OS:<input type="text" name="os" value="${param.os eq null ? obj.oS : param.os}">
            ${objErr.OSError}</br>
            Weight:<input type="number" step="0.1" name="weight" value="${param.weight eq null ? obj.weight : param.weight}">
            ${objErr.weightError}</br>
            
            Region:<input type="text" name="region" value="${param.region eq null ? obj.region : param.region}">
            ${objErr.regionError}</br>
            Year:<input type="number" step="1" name="year" value="${param.year eq null ? obj.year : param.year}">
            ${objErr.yearError}</br>
            
            <input type="submit" name="btn" value="${param.elid eq 0 ? "Create" : "Edit"}">
            <input type="reset" value="Reset">
            <input type="hidden" name="elid" value="${param.elid eq null ? obj.id : param.elid}">
        </form>
    </body>
</html>
