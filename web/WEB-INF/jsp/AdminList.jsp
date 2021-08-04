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
        
        <%@include file="./common/Header.jsp" %>
        
        <div class="container p-3">
            <h2 class="font-weight-bold">
                User list
            </h2>
            
            <hr />

            <form class="mt-3" action = "AdminListServlet" method="POST">
                <div class="row">
                  <div class="form-group col-md-5">
                    <label class="font-weight-bold" for="adminSearchUsername">Username</label>
                    <input
                        type="text"
                        id="adminSearchUsername"
                        class="form-control"
                        placeholder="username"
                        name="admin-search-username"
                        value="${param["admin-search-username"]}"
                    >
                  </div>
                  <div class="form-group col-md-5">
                    <label class="font-weight-bold" for="adminSearchFullname">Full name</label>
                    <input
                        type="text"
                        id="adminSearchFullname"
                        class="form-control"
                        placeholder="full name"
                        name="admin-search-fullname"
                        Value="${param["admin-search-fullname"]}"
                    >
                  </div>
                  <div class="col align-self-end form-group col-md-2">
                    <div>
                      <button type="submit" class="btn btn-success btn-block">Search</button>
                    </div>      
                  </div>
                </div>
             </form>

            <table class="table border">
                <thead class="thead-light">
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">Password</th>
                    <th scope="col">Full name</th>
                    <th scope="col">Role</th>
                    <th scope="col">Phone</th>
                    <th scope="col">Address</th>
                    <th scope="col">Update</th>
                    <th scope="col">Delete</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="${userList}" var="user">
                  <form action="AdminUpdateServlet" method="POST">
                  <tr>
                    <input type="hidden" name="userId" value="${user.getUserId()}" />
                    <th scope="row">${user.getUserId()}</th>
                    <td>${user.getUsername()}</td>
                    <td style="max-width: 8rem">
                        <input
                            class="form-control"
                            type="password"
                            name="password-${user.getUserId()}"
                            value="${user.getPassword()}"
                        >
                        <c:if test="${user.getUserId() eq userErrorObject.getUserId()}">
                            <p class="text-danger">${userErrorObject.getPasswordError()}</p>
                        </c:if>
                    </td>
                    <td>${user.getName()}</td>
                    <td>
                        <select name="role-${user.getUserId()}" class="form-control">
                            <option value="1" <c:if test="${user.getRole() eq 1}"> selected </c:if>>Admin</option>
                            <option value="2" <c:if test="${user.getRole() eq 2}"> selected </c:if>>Customer</option>
                            <option value="3" <c:if test="${user.getRole() eq 3}"> selected </c:if>>Staff</option>
                        </select>
                    </td>
                    <td>${user.getPhone()}</td>
                    <td>${user.getAddress()}</td>
                    <td><button class="btn btn-warning" type="submit">Update</button></td>
                    <td>
                        <a
                            href="AdminDeleteServlet?userId=${user.getUserId()}"
                            role="button"
                            class="btn btn-danger"
                            onclick="return alert('Delete user ${user.getUsername()} ?');"
                        >
                            Delete
                        </a>
                    </td>
                  </tr>
                  </form>
                  </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
