<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户列表</title>
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
    <li><a href="#">微信客户</a> <span class="divider">/</span></li>
    <li class="active">客户列表</li>
</ul>
<div class="row-fluid">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>CustomerID</th>
            <th>OpenID</th>
            <th>昵称</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr class="info">
                <td>${item.cusid}</td>
                <td>${item.openid}</td>
                <td>${item.nickname}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--<%@ include file="/basepage/pager.jsp" %>--%>
</div>
</body>
</html>
