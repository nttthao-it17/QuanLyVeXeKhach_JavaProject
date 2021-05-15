<%-- 
    Document   : detailTrip
    Created on : May 14, 2021, 4:51:12 PM
    Author     : T430s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="trip-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="trip-bit-title text-center">
                    <h2 class="text-uppercase">${trip.tripDescription}</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="trip-f-image">
                <img src="<spring:url value="/images/image.jpg" />" alt="">
            </div>
        </div>

        <div class="col-md-7">
            <ul class="list-group">
                <li class="list-group-item">Giá: ${trip.price} VNĐ</li>
                <li class="list-group-item">Thông tin chuyến đi: ${trip.tripDescription}</li>
                <li class="list-group-item">Xe khách: ${trip.coachName}</li>
                <li class="list-group-item">Ngày khởi hành: ${trip.dateStarted}</li>
                <li class="list-group-item">Giờ xuất phát: ${trip.timeStarted}</li>
            </ul>
            <div>
                <a href="javascript:;" onclick="addCart(${trip.id})" 
                   class="btn btn-danger">
                    <i class="fa fa-shopping-cart"></i> 
                    Thêm vào giỏ
                </a>
            </div>
        </div>
    </div>
</div>



