<%-- 
    Document   : signup
    Created on : Jun 27, 2021, 11:07:28 PM
    Author     : khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <form class="login-form form-group col-md-5 mt-4 py-3 px-4 border rounded shadow" action="SignUpServlet" method="POST">
                <h4>Sign Up A New Account</h4>
                <font color="green">
                    ${requestScope.SUCCESS}
                </font>
                <div class="mt-2">
                    <lable for="txtusername">Username</lable>
                    <input class="form-control" id="txtusername" type="text" name="txtusername" value="${param.txtusername}" />
                    <font color="red">
                        ${errorobj.usernameError}
                    </font>
                </div>
                <div class="mt-2">
                    <lable for="txtpassword">Password</lable>
                    <input class="form-control" id="txtpassword" type="password" name="txtpassword" value="${param.txtpassword}" />
                    <font color="red">
                        ${errorobj.passwordError}
                    </font> 
                </div>
                <div class="mt-2">
                    <lable for="txtname">Full Name</lable>
                    <input class="form-control" id="txtname" type="text" name="txtname" value="${param.txtname}" />
                    <font color="red">
                        ${errorobj.nameError}
                    </font>
                </div>
                <div class="mt-2">
                    <lable for="txtphone">Phone</lable>
                    <input class="form-control" id="txtphone" type="text" name="txtphone" value="${param.txtphone}" />
                    <font color="red">
                        ${errorobj.phoneError}
                    </font>
                </div>
                <div class="mt-2">
                    <lable for="txtaddress">Address</lable>
                    <input class="form-control" id="txtaddress" type="text" name="txtaddress" value="${param.txtaddress}" />
                    <font color="red">
                        ${errorobj.addressError}
                    </font>
                </div>
                <div class="row mt-3 px-3">
                    <button type="submit"  value="Sign Up" name="btn" class="btn btn-success mr-2">Sign up</button>
                    <button type="reset" class="btn btn-warning">Reset</button>
                </div>
                <div class="row mt-3 px-3">
                    <a href="Login.jsp">Login to an existed account</a>
                </div>
            </form>
        </div>
    </body>
</html>
