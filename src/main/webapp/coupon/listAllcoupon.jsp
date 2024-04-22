<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
    <title>List Coupons</title>
</head>
<body>
<h1>優惠券列表</h1>
    <c:if test="${couponPageQty > 0}">

    </c:if>
    <br>
    <table style="width:50%; text-align:center;">
        <tr>
            <th>優惠券編號</th>
            <th>優惠券種類名稱</th>
            <th>使用條件</th>
            <th>折扣比率</th>
            <th>建立日期</th>
            <th>失效日期</th>
            <th>發放日期</th>
            <th>發放狀態</th>
            <th>修改</th>
            <th>刪除</th>
        </tr>
        <c:forEach var="couponVO" items="${couponList}">
            <tr>
                <td>${couponVO.coupNo}</td>
                <td>${couponVO.coupName}</td>
                <td>${couponVO.coupCond}</td>
                <td>${couponVO.coupDisc}</td>
                <td>${couponVO.coupAddDate}</td>
                <td>${couponVO.coupExpDate}</td>
                <td>${couponVO.coupRelDate}</td>
                <td>${couponVO.coupRelStat}</td>
            </tr>
        </c:forEach>
    </table>
<c:if test="${currentPage > 1}">
    <a href="${pageContext.request.contextPath}/coupon/conpon.do?action=getAll&page=1">至第一頁</a>&nbsp;
</c:if>
<c:if test="${currentPage - 1 != 0}">
    <a href="${pageContext.request.contextPath}/coupon/conpon.do?action=getAll&page=${currentPage - 1}">上一頁</a>&nbsp;
</c:if>
<c:if test="${currentPage + 1 <= empPageQty}">
    <a href="${pageContext.request.contextPath}/coupon/conpon.do?action=getAll&page=${currentPage + 1}">下一頁</a>&nbsp;
</c:if>
<c:if test="${currentPage != empPageQty}">
    <a href="${pageContext.request.contextPath}/coupon/conpon.do?action=getAll&page=${empPageQty}">至最後一頁</a>&nbsp;
</c:if>
</body>
</html>