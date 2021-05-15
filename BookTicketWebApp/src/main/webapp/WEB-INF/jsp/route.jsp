<%-- 
    Document   : route
    Created on : May 14, 2021, 8:51:26 PM
    Author     : VIP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
           uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>  

<h1 class="text-center text-success">THÊM TUYẾN ĐI</h1>


<c:url value="/route/add" var="action" />
<form:form method="post" 
           action ="${action}"
           modelAttribute="route">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger"/>
    <div class="form-group">
        <label> <spring:message code="rou.fr" /> </label>
        <form:input cssClass="form-control" path="station_from" />        
    </div>
    <div class="form-group">
        <label> <spring:message code="rou.to" /> </label>
        <form:input cssClass="form-control" path="station_to" />        
    </div>
    <div>
        <form:hidden path="id" />
        <input type="submit" class="btn btn-danger" value="<spring:message code="rou.submit" />" />     
    </div>
    
</form:form>
