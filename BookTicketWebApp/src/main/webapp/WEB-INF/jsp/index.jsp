<%-- 
    Document   : index
    Created on : Apr 24, 2021, 12:41:27 AM
    Author     : VIP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-success">QUẢN LÝ BẾN XE</h1>
<html>
<head>
<style>


/* Dùng trong <div> để định vị nội dung thả xuống */
.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  left: 0;
}
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #e9d8f4;
  min-width: 500px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}


.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}


.dropdown-content a:hover {
  background-color: #58257b;
  color: white;
}


.dropdown:hover .dropdown-content {
  display: block;
}


.dropdown:hover .dropbtn {
  background-color: #984eca;
}
</style>
</head>
<body>

<div class="dropdown">
  <a href="<c:url value="/route" />/?routeId=${r.id}" class="btn btn-info">TUYẾN ĐI</a>
  <div class="dropdown-content">
  <c:forEach items="${routes}" var="rou">
        <li>
            <a href="<c:url value="/" />?rouId=${rou.id}">${rou.station_from} - ${rou.station_to}</a>
        </li>
  </c:forEach>
  </div>
  
</div>

</body>
</html>

<table class="table">
    <tr>
        <th>Mã tuyến đi</th>
        <th>Nơi bắt đầu</th>
        <th>Nơi kết thúc</th>
        <th></th>
    </tr>
    <c:forEach items="${routes}" var="r">
    <tr id="route${r.id}">
        <td>${r.id}</td>
        <td>${r.station_from}</td>
        <td>${r.station_to}</td>
        
        <td>
            <a href="javascript:;" class="btn btn-danger" onclick="deleteRoute(${r.id})">Xóa</a>
            <a href="<c:url value="/route" />/?routeId=${r.id}" class="btn btn-info">Cập nhật</a>
        </td>
    </tr>
    </c:forEach>
</table>


<div>
    <a href="<c:url value="/trip" />/?tripId=${p.id}" class="btn btn-info">CHUYẾN XE</a>
</div>
<table class="table">
    <tr>
        <th>Mã chuyến đi</th>
        <th>Tuyến đi</th>
        <th>Tên hãng xe</th>
        <th>Giá vé</th>
        <th></th>
    </tr>
    <c:forEach items="${trips}" var="p">
    <tr id="trip${p.id}">
        <td>${p.id}</td>
        <td>${p.trip_description}</td>
        <td>${p.coach_name}</td>
        <td>${p.price} VND</td>
        <td>
            <a href="javascript:;" class="btn btn-danger" onclick="deleteTrip(${p.id})">Xóa</a>
            <a href="<c:url value="/trip" />/?tripId=${p.id}" class="btn btn-info">Cập nhật</a>
        </td>
    </tr>
    </c:forEach>
</table>


<script src="<c:url value="/js/main.js" />"></script>
