<%-- 
    Document   : ViewCart
    Created on : Jul 7, 2021, 12:47:44 PM
    Author     : khang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
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
        <c:set var="user" value="${sessionScope.USER}"/>
        <c:set var="laptops" value="${sessionScope.cart}"/>
        <%@include file="../common/Header.jsp" %>
        
        <c:url var="urlRewriting" value="UserListServlet">
        <c:param name="txtlaptopname" value="${requestScope.txtlastname}"/>
        <c:param name="txtminprice" value="${requestScope.txtlastminprice}"/>
        <c:param name="txtmaxprice" value="${requestScope.txtlastmaxprice}"/>
        <c:param name="txtminyear" value="${requestScope.txtlastminyear}"/>
        <c:param name="txtmaxyear" value="${requestScope.txtlastmaxyear}"/>
        <c:param name="btn" value="${requestScope.lastbtn}"/>
        </c:url>
        
        <div class="container">
            <div class="shadow mt-4 p-3">
                <h4 class="font-weight-bold">Your cart</h5>
                <form action="UserBuyServlet">
                <c:if test="${not empty laptops}">                            
                    <table class="table border">
                        <thead class="thead-light">
                            <tr>
                                <th>Name</th>
                                <th>CPU</th>
                                <th>Weight</th>
                                <th>Region</th>
                                <th>Year</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="lap" items="${sessionScope.cart}">                            

                                <tr>
                                    <td>
                                        ${lap.laptop.name}
                                    </td>
                                    <td>
                                        ${lap.laptop.CPU}
                                    </td>
                                    <td>
                                        ${lap.laptop.weight}
                                    </td>
                                    <td>
                                        ${lap.laptop.region}
                                    </td>
                                    <td>
                                        ${lap.laptop.year}
                                    </td>
                                    <td>
                                        <input type="number" name="txtquantity${lap.laptop.id}" value="${lap.quantity}" />
                                        

                                    </td>
                                    <td>
                                        <fmt:formatNumber value="${lap.laptop.price}" maxFractionDigits="3"/>
                                    </td>
                                    <td>
                                        <a href="UserDeleteLaptopServlet?id=${lap.laptop.id}&totalprice=${requestScope.totalprice}">Delete</a>
                                    </td>
                                </tr>

                            </c:forEach>

                            <tr>
                                <td>
                                    Total Price :
                                </td>
                                <td>
                                    <fmt:formatNumber value="${requestScope.totalprice}" maxFractionDigits="3"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                    <input type="hidden" name="txttotalprice" value="${requestScope.totalprice}" /> 
                    <font color="red">
                        ${requestScope.AddressNull}<br/>
                        ${requestScope.Errorquantity}<br/>
                    </font>
                    <font color="red">
                        
                    </font>
                    <div>
                        <label for="txtaddress">Address: </label>
                        <input class="form-control" id="txtaddress" type="text" name="txtaddress" value="" />
                    </div>
                    <input class="btn btn-success col-md-3 mt-2" type="submit" value="Buy" name="btn" />
                </c:if>
                <c:if test="${empty laptops}">
                    <p>
                        Your Cart is empty
                    </p>
                </c:if>

                </form>
            </div>  
        </div>
    </body>
</html>
