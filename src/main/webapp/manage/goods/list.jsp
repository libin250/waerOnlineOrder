<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>goods_list</title>
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
    <li><a href="#">菜品信息管理</a> <span class="divider">/</span></li>
    <li class="active">菜品列表</li>
</ul>

<div class="row-fluid">
    <form class="form-search" style="padding: 5px"
          action="${pageContext.request.contextPath}/goods/list"
          method="post">
        <label>菜品名称：</label><input class="input-medium search-query" value="${param.gname}" type="text"
                                   name="gname"/>
        状态：
        <select name="gstate">
            <c:choose>
                <c:when test="${param.gstate==1}">
                    <option value="-1">全部</option>
                    <option value="1" selected="selected">可用</option>
                    <option value="0">不可用</option>
                </c:when>
                <c:when test="${param.gtstate==0}">
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
                onclick="window.location.href='${pageContext.request.contextPath}/goods/toadd';">增加
        </button>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>菜名</th>
            <th>菜品类型</th>
            <th>封面</th>
            <th>价格</th>
            <th style="width: 200px">描述</th>
            <th>需要时间</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${p.list}" var="gdto">
            <%--<c:forEach items="${list}" var="gdto">--%>
            <tr>
                <td>${gdto.gname}</td>
                <td>${gdto.gtname}</td>
                <td><img src="${pageContext.request.contextPath}${gdto.gimg}" width="100px"></td>
                <td>${gdto.gprice}/份</td>
                <td>${gdto.gcontent}</td>
                <td>${gdto.gtime} 分钟</td>
                <td>
                    <c:choose>
                        <c:when test="${gdto.gstate==1}">可用</c:when>
                        <c:otherwise>不可用</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath }/goods/toedit/${gdto.gid}">编辑</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@ include file="/basepage/pager.jsp" %>
</div>

</body>
</html>
