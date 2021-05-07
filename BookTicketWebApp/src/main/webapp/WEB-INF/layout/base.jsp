<%-- 
    Document   : base
    Created on : May 4, 2021, 9:45:26 PM
    Author     : VIP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>
            <tiles:insertAttribute name="title" />
        </title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>
    <body>
        <div class=""container>
            <!-- header -->
            <tiles:insertAttribute name="header" />

            <!-- content -->
            <tiles:insertAttribute name="content" />

            <!-- footer -->
            <tiles:insertAttribute name="footer" />
            </div>
    </body>
</html>
