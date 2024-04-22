<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
    <title>List Coupons</title>
</head>
<body>
<h1>優惠券列表</h1>
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
<p><input type="submit" value="送出"></p>
<input type="hidden" name="action" value="compositeQuery">
<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>

</body>
</html>