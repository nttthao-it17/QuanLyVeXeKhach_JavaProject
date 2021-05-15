<%-- 
    Document   : feedback
    Created on : May 15, 2021, 12:58:31 AM
    Author     : T430s
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="feedback-container">
    <h3 class="feedback-title">Phản hồi của khách hàng về dịch vụ của chúng tôi</h3>
    <table class="table table-bordered feedback-users feedback-table">
        <tr>
            <th class="table-item">Mã phản hồi</th>
            <th class="table-item">Người viết</th>
            <th class="table-item">Nội dung phản hồi</th>
            <th class="table-item">Ngày viết</th>
        </tr>
        <c:forEach items="${feedback}" var="fb">
            <tr>
                <td>${fb.id}</td>
                <td>${fb.user.fullname}</td>
                <td>${fb.description}</td>
                <td>${fb.createdDate}</td>
            </tr>
        </c:forEach>
    </table>
    <button class="btn btn-info save-feedback-btn"><a class="save-btn-text" href="<spring:url value="/feedback/add" />">Viết phản hồi</a></button>
</div>



