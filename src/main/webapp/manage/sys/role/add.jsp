<%--
  Created by IntelliJ IDEA.
  User: FAST
  Date: 2019/10/25
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>增加角色</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
            type="text/javascript"></script>
    <script>

    </script>
</head>
<body>
<ul class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/SysRole/list">角色管理</a> <span class="divider">/</span></li>
    <li class="active">增加角色</li>
</ul>
    <form action="${pageContext.request.contextPath}/SysRole/add">
        <label>角色名称：</label><input type="text" name="rolename"/></br>
        <label>角色状态：</label>
        <select name="rolestate">
            <option value="1">可用</option>
            <option value="0">不可用</option>
        </select></br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
