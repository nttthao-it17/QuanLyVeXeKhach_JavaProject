<%-- 
    Document   : index
    Created on : Apr 24, 2021, 12:41:27 AM
    Author     : VIP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <h2 class="section-title">DANH SÁCH CHUYẾN ĐI</h2>
    <div class="row">
        <c:forEach items="${trips}" var="trip">
            <div class="col-md-3 single-trip">
                <div class="trip-f-image">
                    <img class="img-setting" src="<spring:url value="/images/image.jpg" />">
                    <div class="trip-hover">
                        <a href="javascript:;" onclick="addCart(${trip.id})" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Thêm vào giỏ</a>
                        <a href="<spring:url value="/trips/${trip.id}" />" class="view-details-link"><i class="fa fa-link"></i> Xem chi tiết</a>
                    </div>
                </div>

                <h2><a href="#">${trip.tripDescription}</a></h2>
                <h4>${trip.dateStarted}</h4>
                <div class="trip-carousel-price">
                    <ins>${trip.price} VNĐ</ins> 
                </div> 
            </div>
        </c:forEach>
    </div>
</div>

<script>
function addCart(tripId, tripDescription) {
    $.ajax({
        url: "/BookTicketWebApp/api/cart",
        type: "POST",
        data: {
            tripId: tripId,
            num: 1
        },
        success: function (data) {
            var a = $(".trip-count").text();
            a = a === "" ? 0:parseInt(a);
            $(".trip-count").text(a + 1);
        },
        error: function (jqXHR) {
            alert(jqXHR);
        }
    });
}
</script>

