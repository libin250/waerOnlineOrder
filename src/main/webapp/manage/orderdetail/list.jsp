<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>orderdetail</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
            type="text/javascript"></script>
</head>
<body>
<ul class="breadcrumb">
    <li><a href="#">订单详细信息</a> <span class="divider">/</span></li>
    <li class="active">订单详细信息列表</li>
</ul>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>微信昵称</th>
        <th>菜品名称</th>
        <th>需要时间</th>
        <th>菜品卖价</th>
        <th>购买数量</th>
        <th>下单时间</th>
        <th>结账金额</th>
        <th>订单状态</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="odto">
        <tr>
            <td>${odto.nickname}</td>
            <td>${odto.gname}</td>
            <td>${odto.gtime}</td>
            <td>${odto.odprice}</td>
            <td>${odto.odcount}</td>
            <td>${odto.ordertime}</td>
            <td>${odto.ordertotleprice}</td>
            <td>
                <c:choose>
                    <c:when test="${odto.orderstate==0}">临时</c:when>
                    <c:when test="${odto.orderstate==1}">下单</c:when>
                    <c:when test="${odto.orderstate==2}">处理中</c:when>
                    <c:when test="${odto.orderstate==3}">完成</c:when>
                    <c:otherwise>其他</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
