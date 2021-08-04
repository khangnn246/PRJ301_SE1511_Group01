<%-- 
    Document   : UserViewProfile
    Created on : Jul 10, 2021, 2:29:40 AM
    Author     : khang
--%>

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
            <div class="col-md-10 my-4 border shadow p-3">
                <h3 class="font-weight-bold">Your Profile</h3>
                <form class="form-group mt-3" action="UserUpdateServlet">
                    <div class="row mt-2">
                        <div class="col-md-6">
                            <label for="txtusername">Username</label>
                            <input class="form-control" type="text" id="txtusername" readOnly name="txtusername" value="${sessionScope.USER.username}" />
                            <font color="red">
                                ${requestScope.Error.usernameError}
                            </font>
                        </div>
                        <div class="col-md-6">
                            <label for="txtpassword">Password</label>
                            <input class="form-control" type="password" id="txtpassword" name="txtpassword" value="${sessionScope.USER.password}" />
                            <font color="red">
                                ${requestScope.Error.passwordError}
                            </font>
                        </div>
                    </div>
                            ${param.name eq null ? obj.name : param.name}
                    <div class="row mt-2">
                        <div class="col-md-6">
                            <label for="txtfullname">Full name</label>
                            <input class="form-control" type="text" id="txtfullname" name="txtfullname" value="${sessionScope.USER.name}" />
                            <font color="red">
                                ${requestScope.Error.nameError}
                            </font>
                        </div>
                        <div class="col-md-6">
                            <label for="txtphone">Phone</label>
                            <input class="form-control" type="text" id="txtphone" name="txtphone" value="${sessionScope.USER.phone}" />
                            <font color="red">
                                ${requestScope.Error.phoneError}
                            </font>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-12">
                            <label for="txtaddress">Address</label>
                            <input class="form-control" type="text" id="txtaddress" name="txtaddress" value="${sessionScope.USER.address}" />
                            <font color="red">
                                ${requestScope.Error.addressError}
                            </font>
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col-md-4">
                            <input class="btn btn-info" type="submit" value="Update Information" name="btn" />
                        </div>
                        <div class="col-md-8 align-self-center">
                            <font color="green">
                                ${requestScope.Updatesuccess}
                            </font>
                        </div>
                    </div>
                </form>
            </div>
        </div>
                
    </body>
</html>
