<%-- 
    Document   : base
    Created on : May 4, 2021, 9:45:26 PM
    Author     : VIP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <!--<link rel="icon" href="/images/logo.png" type="x-icon">-->
        <title>Đặt vé xe khách</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title><tiles:insertAttribute name="title" /></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="<spring:url value="/css/main.css" />">
    </head>
    <body>
        <div class="container">
            <!-- header -->
            <tiles:insertAttribute name="header" />

            <!-- content -->
            <tiles:insertAttribute name="content" />

            <!-- footer -->
            <tiles:insertAttribute name="footer" />
        </div>

        <script src="https://code.jquery.com/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <script src="<spring:url value="/js/jquery.sticky.js" />"></script>
        <script src="<spring:url value="/js/jquery.easing.1.3.min.js" />"></script>
        <script src="<spring:url value="/js/main.js" />"></script>
        <script src="<spring:url value="/js/cart.js" />"></script>
    </body>
</html>
