<%-- 
    Document   : ListLaptopEmp
    Created on : Jul 8, 2021, 10:38:47 PM
    Author     : SE140866
--%>

<%@page import="DAO.LaptopDAO"%>
<%@page import="java.text.DecimalFormat"%>
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
               <h4 class="font-weight-bold">Employee laptop list</h4>
                <form class="row p-2" action="EmployeeLoadListServlet" method="POST">
                    <div class="col-md-3">
                        <label for="searchID">Laptop Id</label>
                        <input class="form-control" type="text" id="searchID" name="searchID" value="${param.searchID}" />
                    </div>
                    <div class="col-md-7">
                        <label for="searchName">Laptop name</label>
                        <input class="form-control" type="text" id="searchName" name="searchName" value="${param.searchName}" />
                    </div>
                    <div class="col-md-2 align-self-end">
                        <button class="btn btn-info btn-block" type="submit" name="search" value="Search">Search</button>
                    </div>

                    <table class="table border table-responsive m-3">
                        <thead class="thead-light">
                            <tr>
                                <th>ID </th>
                                <th>Name </th>
                                <th>Price </th>
                                <th>CPU </th>
                                <th>Ram </th>
                                <th>Screen </th>
                                <th>Graphic </th>
                                <th>Disk </th>
                                <th>OS </th>
                                <th>Weight </th>
                                <th>Region </th>
                                <th>Year </th>
                                <th></th>
                                <th></th>
                            </tr>
                            <c:forEach items="${listLaptop}" var="obj">
                                <tr>
                                    <td>${obj.id}</td>
                                    <td>${obj.name}</td>
                                    <td>${obj.price}</td>
                                    <td>${obj.CPU}</td>
                                    <td>${obj.ram}</td>
                                    <td>${obj.screen}</td>
                                    <td>${obj.graphic}</td>
                                    <td>${obj.disk}</td>
                                    <td>${obj.oS}</td>
                                    <td>${obj.weight}</td>
                                    <td>${obj.region}</td>
                                    <td>${obj.year}</td>
                                    <td>
                                        <input
                                            class="btn btn-outline-danger"
                                            type="submit"
                                            formaction="EmployeeEditServlet?elid=${obj.id}"
                                            value="Edit"
                                        />
                                    </td>
                                    <td>
                                        <button
                                            class="btn btn-danger"
                                            type="submit"
                                            formaction="EmployeeDeleteServlet?dlid=${obj.id}"
                                            value="Delete"
                                            onClick="return confirm('Delete ${obj.id}')"
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </thead>
                    </table>
                </form>           
           </div>
        </div>
    </body>
</html>
