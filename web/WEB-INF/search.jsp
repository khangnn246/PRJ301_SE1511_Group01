<%-- 
    Document   : search
    Created on : Jun 28, 2021, 1:43:28 PM
    Author     : khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.USER.name}</h1>
        <form action="SignOutServlet">
            <input type="submit" value="Sign Out" name="btn" />
        </form>
        <c:set var="role" value="${sessionScope.USER.role}"/>
        <c:if test="${role == 1}">
            
        </c:if>
        <c:if test="${role == 2}">
            
        </c:if>
        <c:if test="${role == 3 }">
            
        </c:if>
    </body>
</html>
