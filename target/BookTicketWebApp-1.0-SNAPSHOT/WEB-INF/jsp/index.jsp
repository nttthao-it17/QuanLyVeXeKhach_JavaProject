<%-- 
    Document   : index
    Created on : Apr 24, 2021, 12:41:27 AM
    Author     : VIP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-success">DANH SACH CHUYEN DI</h1>

<table class="table">
    <tr>
        <th>Ma chuyen di</th>
        <th>Tong so ngay</th>
    </tr>
    <c:forEach items="${trips}" var="p">
    <tr>
        <td>${p.id}</td>
        <td>${p.amount_of_trip_on_day}</td>
     
    </tr>
    </c:forEach>
</table>
