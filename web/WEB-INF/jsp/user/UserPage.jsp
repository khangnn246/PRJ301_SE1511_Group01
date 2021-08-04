<%-- 
    Document   : UserPage
    Created on : Jul 4, 2021, 9:15:48 PM
    Author     : khang
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        
        <div class="container">
            
            <form class="form-group row p-2" action="UserListServlet" method="POST">
                <div class="col-md-4">
                    <label for="txtlaptopname">Name</label>
                    <input class="form-control" type="text" id="txtlaptopname" name="txtlaptopname" value="${param.txtlaptopname}" />
                </div>
                <div class="col-md-2">
                    <label for="txtminprice">Min price</label>
                    <input class="form-control" type="number" step="0.1" id="txtminprice" name="txtminprice" value="${param.txtminprice}" />
                </div>
                <div class="col-md-2">
                    <label for="txtmaxprice">Max price</label>
                    <input class="form-control" type="number" step="0.1" id="txtmaxprice" name="txtmaxprice" value="${param.txtmaxprice}" />
                </div>
                <div class="col-md-2">
                    <label for="txtminyear">Min year</label>
                    <input class="form-control" type="number" step="1" id="txtminyear" name="txtminyear" value="${param.txtminyear}" />
                </div>
                <div class="col-md-2">
                    <label for="txtmaxyear">Max year</label>
                    <input class="form-control" type="number" step="1" id="txtmaxyear" name="txtmaxyear" value="${param.txtmaxyear}" />
                </div>
                <div class="px-3 mt-2">
                    <input class="btn btn-success" type="submit" value="Search" name="btn" />
                    <input class="btn btn-success ml-2" type="submit" value="SearchAllLaptop" name="btn" />
                </div>
            </form>
        
            <c:set var="txtlastname" value="${param.txtlaptopname}"/>
            <c:set var="txtlastminprice" value="${param.txtminprice}"/>
            <c:set var="txtlastmaxprice" value="${param.txtmaxprice}"/>
            <c:set var="txtlastminyear" value="${param.txtminyear}"/>
            <c:set var="txtlastmaxyear" value="${param.txtmaxyear}"/>
            <c:set var="btnlast" value="${param.btn}"/>
            <c:if test="${empty requestScope.ErrorInput}">
                <c:if test="${not empty requestScope.LapList}">
                    <div class="row">
                        <c:forEach var="lap" items="${requestScope.LapList}">
                            <div class="col-md-3 p-2">
                                <form action="UserAddItemToCart">
                                    <input type="hidden" name="txtLaptopId" value="${lap.id}" />
                                    <div class="card border shadow">
                                        <div class="card-body">
                                            <h5 class="font-weight-bold">${lap.name}</h5>
                                            <p class="mb-1">CPU: ${lap.CPU}</p>
                                            <p class="mb-1">Ram: ${lap.ram}</p>
                                            <p class="mb-1">Screen: ${lap.screen}</p>
                                            <p class="mb-2">Year: ${lap.year}</p>
                                            <h6 class="font-weight-bold">
                                                Price: <fmt:formatNumber value="${lap.price}" maxFractionDigits="3"/> $
                                            </h6>
                                            <div class="row px-3">
                                                <div class="mr-2">
                                                    <input type="hidden" name="lastname" value="${txtlastname}" />
                                                    <input type="hidden" name="lastminprice" value="${txtlastminprice}" />
                                                    <input type="hidden" name="lastmaxprice" value="${txtlastmaxprice}" />
                                                    <input type="hidden" name="lastminyear" value="${txtlastminyear}" />
                                                    <input type="hidden" name="lastmaxyear" value="${txtlastmaxyear}" />
                                                    <input type="hidden" name="lastbtn" value="${btnlast}" />
                                                    <input class="btn btn-info" type="submit" value="Add To Cart" name="btnAdd" />
                                                </div>
                                                <div>
                                                    <c:url var="urlRewriting" value="UserViewDetailServlet">
                                                        <c:param name="id" value="${lap.id}"/>
                                                        <c:param name="txtlastname" value="${param.txtlaptopname}"/>
                                                        <c:param name="txtlastminprice" value="${param.txtminprice}"/>
                                                        <c:param name="txtlastmaxprice" value="${param.txtmaxprice}"/>
                                                        <c:param name="txtlastminyear" value="${param.txtminyear}"/>
                                                        <c:param name="txtlastmaxyear" value="${param.txtmaxyear}"/>
                                                        <c:param name="btn" value="${btnlast}"/>
                                                    </c:url>
                                                    <a type="button" class="btn btn-outline-info" href="${urlRewriting}">Detail</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            <c:if test="${empty requestScope.LapList }">
                <h2>
                    No record is search
                </h2>
            </c:if>
        </c:if>
                
    </div>

</body>
</html>
