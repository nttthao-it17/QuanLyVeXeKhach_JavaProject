<%-- 
    Document   : registerForm
    Created on : May 14, 2021, 4:41:02 PM
    Author     : T430s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h1 class="text-center text-uppercase">
        <spring:message code="user.register" />
    </h1>
    <spring:url value="/register" var="action" />
    <form:form action="${action}" modelAttribute="user" method="post" >
        <form:errors path="*" cssClass="alert alert-danger" element="div" />
        
        <div class="form-group">
            <label for="fullnameId">
                <spring:message code="user.fullname" />
            </label>
            <form:input path="fullname" id="fullnameId" 
                        cssClass="form-control" />
            <form:errors path="fullname" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="emailId">
                <spring:message code="user.email" />
            </label>
            <form:input path="email" id="emailId" 
                        cssClass="form-control" />
            <form:errors path="email" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="phoneId">
                <spring:message code="user.phone" />
            </label>
            <form:input path="phone" id="phoneId" 
                        cssClass="form-control" />
            <form:errors path="phone" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="usernameId">
                <spring:message code="user.username" />
            </label>
            <form:input path="username" id="usernameId" cssClass="form-control" />
            <form:errors path="username" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="passwordId">
                <spring:message code="user.password" />
            </label>
            <form:input id="passwordId" path="password" 
                        cssClass="form-control" type="password" />
            <form:errors path="password" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <label for="confirmPasswordId">
                <spring:message code="user.confirmPassword" />
            </label>
            <form:input id="confirmPasswordId" path="confirmPassword" 
                        cssClass="form-control" type="password" />
            <form:errors path="confirmPassword" cssClass="text-danger" />
        </div>
        <div class="form-group">
            <form:button class="pull-right">
                <spring:message code="user.register" />
            </form:button>
        </div>
    </form:form>
</div>
