<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
    <title>FallElove後台：優惠券管理</title>
</head>
<body>
<h1>優惠券管理</h1>
<a href="${pageContext.request.contextPath}/coupon/coupon.do?action=getAll">查詢所有優惠券</a>
<br>
<h3><b>複合查詢(使用 Criteria Query)：</b></h3>
<form action="${pageContext.request.contextPath}/coupon/coupon.do" method="post">
    <p><label>優惠券種類查詢</label></p>
    <input type="text" name="coupName">
    <p><label>優惠券發放狀態</label></p>
    <select name="coupRealStat">
        <option value="">選擇發放狀態</option>
        <option value="0">未發放</option>
        <option value="1">已發放</option>
    </select>
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="compositeQuery">
</form>
</body>
</html>
