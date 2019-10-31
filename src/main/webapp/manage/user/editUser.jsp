<%--
  Created by IntelliJ IDEA.
  User: Snorlax
  Date: 2019/10/28
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
      href="${pageContext.request.contextPath}/stylesheets/theme.css">
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
<script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
        type="text/javascript"></script>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>

<ul class="breadcrumb">
    <li><a href="#">用户管理</a> <span class="divider">/</span></li>
    <li class="active">修改用户信息</li>
</ul>

<div class="row-fluid">
    <div class="span12">
        <form class="form-horizontal"
              action="${pageContext.request.contextPath}/user/edit"
              method="post">
            <div class="control-group">
                <label class="control-label" for="username">用户昵称:</label>
                <div class="controls">
                    <input id="username" value="${user.username}" type="text" name="username" />
                    <input type="hidden" value="${user.userid}" name="userid" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="usertruename">真实姓名:</label>
                <div class="controls">
                    <input id="usertruename" value="${user.usertruename}" type="text" name="usertruename" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="roleid">用户角色:</label>
                <div class="controls">
                    <select id="roleid" name="roleid">
                        <c:forEach items="${list}" var= "item">
                            <option value="${item.roleid}">${item.rolename}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="userpwd">用户密码:</label>
                <div class="controls">
                    <input id="userpwd" value="${user.userpwd}" type="password" name="userpwd" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="usersex">用户性别:</label>
                <div class="controls">
                    <select id="usersex" name="usersex">
                        <c:choose>
                            <c:when test="${user.usersex==0}">
                                <option value="1">可用</option>
                                <option value="0" selected="selected">不可用</option>
                            </c:when>
                            <c:otherwise>
                                <option value="1" selected="selected">可用</option>
                                <option value="0">不可用</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="userstate">用户状态：</label>
                <div class="controls">
                    <select id="userstate" name="userstate">
                        <c:choose>
                            <c:when test="${user.userstate==0}">
                                <option value="1">可用</option>
                                <option value="0" selected="selected">不可用</option>
                            </c:when>
                            <c:otherwise>
                                <option value="1" selected="selected">可用</option>
                                <option value="0">不可用</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="submit" class="btn" value="提交" />
                    <button class="btn btn-primary" type="button" onclick="javascript:location.href='${pageContext.request.contextPath}/user/allUser';">返回</button>
                </div>
            </div>

        </form>

    </div>
</div>

</body>
</html>
