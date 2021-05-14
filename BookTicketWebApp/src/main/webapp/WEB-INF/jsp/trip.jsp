<%-- 
    Document   : trip
    Created on : May 7, 2021, 3:47:42 PM
    Author     : VIP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" 
           uri="http://www.springframework.org/tags/form" %>

<%@ taglib prefix="spring" 
           uri="http://www.springframework.org/tags" %>  

<h1 class="text-center text-success">THÊM CHUYẾN ĐI</h1>


<c:url value="/trip/add" var="action" />
<form:form method="post" 
           action ="${action}"
           modelAttribute="trip">
    <form:errors path="*" element="div" 
                 cssClass="alert alert-danger"/>
    <div class="form-group">
        <label> <spring:message code="trip.desc" /> </label>
        <form:input cssClass="form-control" path="trip_description" />        
    </div>
    <div class="form-group">
        <label> <spring:message code="trip.coach_name" /> </label>
        <form:input cssClass="form-control" path="coach_name" />        
    </div>
    <div class="form-group">
        <label> <spring:message code="trip.price" /> </label>
        <form:input cssClass="form-control" path="price" />        
    </div>
    <div class="form-group">
        <label> <spring:message code="trip.rou" /> </label>
        <form:select path="route" cssClass="form-control">
            <c:forEach items="${routes}" var="rou">
                <c:if test="${rou.id == trip.route.id}">"
                    <option selected value="${rou.id}">${rou.station_from} </option>
                </c:if>
                <c:if test="${rou.id != trip.route.id}">"
                    <option value="${rou.id}">${rou.station_from} </option>
                </c:if>
            </c:forEach>
        </form:select>       
    </div>
    <div>
        <form:hidden path="id" />
        <input type="submit" class="btn btn-danger" value="<spring:message code="trip.submit" />" />     
    </div>
    
</form:form>
