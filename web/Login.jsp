<%-- 
    Document   : newjsp
    Created on : Jun 18, 2021, 3:21:27 PM
    Author     : khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        
        <%@include file="/WEB-INF/jsp/common/Header.jsp" %>
        
        <div class="container d-flex justify-content-center">
            <form class="login-form form-group col-md-5 mt-4 py-3 px-4 border rounded shadow" action="LoginServlet" method="POST">
                <h4>Login Page</h4>
                <div class="mt-2">
                    <lable for="username">Username</lable>
                    <input class="form-control" id="username" type="text" name="txtusername" value="${param.txtusername}" />
                </div>
                <div class="mt-2">
                    <lable for="password">Password</lable>
                    <input class="form-control" id="password" type="password" name="txtpassword" value="" />
                </div>
                <div>
                    <font color="red">
                        ${requestScope.ErrorLogin}
                        ${requestScope.NotLogin}
                    </font>
                </div>
                <div class="row mt-3 px-3">
                    <button type="submit" class="btn btn-success mr-2">Login</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                </div>
                <div class="row mt-3 px-3">
                    <a href="SignUpDispatchServlet">Sign up a new account</a>
                </div>
            </form>
        </div>
    </body>
</html>
