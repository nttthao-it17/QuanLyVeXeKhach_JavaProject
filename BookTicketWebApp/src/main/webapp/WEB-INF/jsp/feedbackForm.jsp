<%-- 
    Document   : feedbackForm
    Created on : May 15, 2021, 1:52:13 AM
    Author     : T430s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h1 class="text-center text-uppercase">
        <spring:message code="feedback.submit" />
    </h1>
    <spring:url value="/feedback/add" var="action" />
    <form:form action="${action}" modelAttribute="addFeedback"
               method="post" enctype="multipart/form-data" >
        <form:errors path="*" cssClass="alert alert-danger" element="div" />

        <div class="form-group">
            <label for="descriptionId">
                <spring:message code="feedback.description" />
            </label>
            <form:textarea id="descriptionId" path="description" 
                           cssClass="form-control" />
            <form:errors path="description" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <form:button class="pull-right">
                <spring:message code="feedback.submit" />
            </form:button>
        </div>
    </form:form>
</div>
