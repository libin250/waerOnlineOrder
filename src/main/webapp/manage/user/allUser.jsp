<%--
  Created by IntelliJ IDEA.
  User: Snorlax
  Date: 2019/10/28
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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


<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">

            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>当前用户 —— 超级管理员</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/user/toadd">新增</a>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <%--<th>用户id</th>--%>
                    <%--<th>角色ID</th>--%>
                    <th>用户名</th>
                    <th>密码</th>
                    <th>真实名</th>
                    <th>性别</th>
                        <th>用户角色</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${p.list}" var="userInfo">
                    <tr>
                        <%--<td>${userInfo.userid}</td>--%>
                        <%--<td>${userInfo.roleid}</td>--%>
                        <td>${userInfo.username}</td>
                        <td>${userInfo.userpwd}</td>
                        <td>${userInfo.usertruename}</td>
                        <td>
                            <c:choose>
                                <c:when test="${userInfo.usersex==1}">
                                    男
                                </c:when>
                                <c:otherwise>
                                    女
                                </c:otherwise>
                            </c:choose>
                        </td>
                            <td>${userInfo.rolename}</td>
                        <td>
                            <c:choose>
                                <c:when test="${userInfo.userstate==1}">
                                    可用
                                </c:when>
                                <c:otherwise>
                                    不可用
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user/toedit/${userInfo.userid}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
</head>
</body>
</html>
