<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
<script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
	type="text/javascript"></script>

<title>top</title>
</head>
<body>
<!--top-->
<div class="itop">
    <div class="itop_left">
        <h1 class="itop_left_h1_2">waer点餐后台管理系统</h1>
    </div>
    <div class="itop_right">
        <h3 class="itop_right_r">欢迎${sessionScope.LOGIN_USER.username}</h3>
    </div>
</div>


</body>
</html>