<%-- 
    Document   : cart
    Created on : May 14, 2021, 4:43:51 PM
    Author     : T430s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<div class="trip-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="trip-bit-title text-center">
                    <h2 class="text-uppercase">GIỎ HÀNG</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container cart-container">
    <h2 class="text-center">CÁC SẢN PHẨM ĐÃ CHỌN</h2>
    <table class="table table-bordered seleted-trips">
        <tr>
            <th class="table-item">Mã chuyến đi</th>
            <th class="table-item">Thông tin chuyến đi</th>
            <th class="table-item">Ngày khởi hành</th>
            <th class="table-item">Giá vé</th>
            <th class="table-item">Số lượng vé</th>
        </tr>
        <c:forEach items="${carts}" var="cart">
            <tr>
                <td>${cart.trip.id}</td>
                <td>${cart.trip.tripDescription}</td>
                <td>${cart.trip.dateStarted}</td>
                <td><fmt:formatNumber type="number" maxFractionDigits="3" 
                                  value="${cart.trip.price}" />  VNĐ</td>
                <td>${cart.num}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="3" class="text-right">Tổng cộng</td>
            <td colspan="2"><fmt:formatNumber type="number" maxFractionDigits="3" 
                              value="${sum}" /> VNĐ</td>
        </tr>
    </table>
    <div class="pull-right">
        <input type="button" class="btn save-feedback-btn" onclick="pay()"
               value="<spring:message code="cart.pay" />" />
    </div>
</div>

<script>
    function pay() {
        if (confirm("Bạn muốn thanh toán?")) {
            $.ajax({
                url: "/BookTicketWebApp/api/cart/pay",
                type: "POST",
                success: function (data, textStatus, jqXHR) {
                    if (data === "")
                        $(".seleted-trips").hide("slow");
                    else
                        alert("Vui lòng đăng nhập để thanh toán!!!");
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert("Đã có lỗi khi thanh toán!!!");
                }
            });
        }
    }
</script>
