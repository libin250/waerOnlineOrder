<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>角色管理</title>
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
    <li><a href="#">角色管理</a> <span class="divider">/</span></li>
    <li class="active">角色列表</li>
</ul>


<div class="row-fluid">
    <form class="form-search" style="padding: 5px"
          action="${pageContext.request.contextPath}/SysRole/list"
          method="post">
        <%--<label>角色名称：</label> <input class="input-medium search-query"--%>
                                    <%--type="text" value="${sysrole.rolename}" name="rolename"/>--%>
        <label>角色名称：</label> <input style="width:200px;height: 30px;"
                                    type="text" value="${sysrole.rolename}" name="rolename"/>
        状态：
        <select name="rolestate">
            <c:choose>
                <c:when test="${sysrole.rolestate==1}">
                    <option value="-1">全部</option>
                    <option value="1" selected="selected">可用</option>
                    <option value="0">不可用</option>
                </c:when>
                <c:when test="${sysrole.rolestate==0}">
                    <option value="-1">全部</option>
                    <option value="1">可用</option>
                    <option value="0" selected="selected">不可用</option>
                </c:when>
                <c:otherwise>
                    <option value="-1">全部</option>
                    <option value="1">可用</option>
                    <option value="0">不可用</option>
                </c:otherwise>
            </c:choose>
        </select>
        <button type="submit" class="btn">查找</button>
        <button class="btn btn-success" type="button"
                onclick="window.location.href='${pageContext.request.contextPath}/SysRole/toadd'">增加
        </button>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>角色名称</th>
            <th>状态</th>
            <th>编辑</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="item">
            <tr>
                <td>${item.rolename}</td>
                <td><c:choose>
                    <c:when test="${item.rolestate==1}">可用</c:when>
                    <c:otherwise>不可用</c:otherwise>
                </c:choose></td>
                <td><a href="${pageContext.request.contextPath}/SysRole/toedit/${item.roleid}">编辑</a>
                    <a href="${pageContext.request.contextPath}/SysRoleFun/init/${item.roleid}">权限</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>