<%-- 
    Document   : header
    Created on : May 4, 2021, 9:49:11 PM
    Author     : VIP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
        </li>
        <c:forEach items="${routes}" var="rou">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/" />?rouId=${rou.id}">${rou.station_from}</a>
        </li>
        </c:forEach>
       <ul>
   

</ul>
    </ul>
</nav>
