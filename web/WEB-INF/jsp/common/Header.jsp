<%-- 
    Document   : Header.jsp
    Created on : Jul 4, 2021, 4:37:24 PM
    Author     : congt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-xl navbar-light d-flex shadow-div shadow-sm">
    <div class="container">
        <div class="mr-auto p-2">
            <a class="navbar-brand" href="/Assignment">
                <h3 style="font-family: Satisfy, cursive; margin-bottom: 0px;">Welcome</h3>
            </a>
        </div>

        <div class="p-2">
                <ul class="nav justify-content-between list-unstyled">
                    <c:if test="${USER eq null}">
                        <li>
                            <a class="nav-link normal-link font-weight-bold" href="Login.jsp">Login</a>
                        </li>
                        <li>
                            <a class="nav-link normal-link font-weight-bold" href="SignUp.jsp">Register</a>
                        </li>
                    </c:if>
                    <c:if test="${USER.getRole() eq 1}">
                        <!-- Admin -->
                        <li>
                            <a class="nav-link admin-link font-weight-bold" href="/Assignment">Admin</a>
                        </li>
                    </c:if>
                    <c:if test="${USER.getRole() eq 2}">
                        <!-- Customer -->
                        <li>
                            <a class="nav-link admin-link font-weight-bold" href="UserViewProfileServlet?btn=View+Profile">${USER.name}</a>
                        </li>
                        <li>
                            <a class="nav-link normal-link font-weight-bold" href="UserListServlet">Home</a>
                        </li>
                        <li>
                            <a class="nav-link normal-link font-weight-bold" href="UserViewOrderServlet">Your order</a>
                        </li>
                        <li>
                            <form action="UserViewCartServlet" >
                                <input type="hidden" name="txtlastname" value="${txtlastname}" />
                                <input type="hidden" name="lastminprice" value="${txtlastminprice}" />
                                <input type="hidden" name="lastmaxprice" value="${txtlastmaxprice}" />
                                <input type="hidden" name="lastminyear" value="${txtlastminyear}" />
                                <input type="hidden" name="lastmaxyear" value="${txtlastmaxyear}" />
                                <input type="hidden" name="lastbtn" value="${btnlast}" />
                                <button type="submit" class="nav-link normal-link font-weight-bold">
                                    <span src="/WEB-INF/statics/icon/shopping-cart.svg" alt="Cart"/>
                                    <i class="fas fa-shopping-cart"></i>
                                     Your cart
                                </button>
                            </form>
                        </li>
                    </c:if>
                    <c:if test="${USER.getRole() eq 3}">
                        <!-- Staff -->
                        <li>
                            <a class="nav-link admin-link font-weight-bold" href="EmployeeLoadListServlet">Employee ${USER.name}</a>
                        </li>
                        <li>
                            <a class="nav-link normal-link font-weight-bold" href="EmployeeEditServlet?elid=0">Create new laptop</a>
                        </li>
                    </c:if>
                    <c:if test="${USER ne null}">
                        <li>
                            <a class="nav-link normal-link font-weight-bold" href="SignOutServlet">Logout</a>
                        </li>
                    </c:if>
                </ul>
        </div>
    </div>    
</nav>
