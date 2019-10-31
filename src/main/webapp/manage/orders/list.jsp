<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>order</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
            type="text/javascript"></script>

    <script language="javascript">

    </script>
</head>
<body>

<ul class="breadcrumb">
    <li><a href="#">订单</a> <span class="divider">/</span></li>
    <li class="active">订单列表</li>
</ul>

<div class="row-fluid">
    <form class="form-search" style="padding: 5px"
          action="${pageContext.request.contextPath}/orders/list"
          method="post">
        <label>用户昵称：</label> <input class="input-medium search-query"
                                    type="text" value="${param.nickname}" name="nickname"/>
        订单状态：
        <select name="orderstate">
            <c:choose>
                <c:when test="${param.orderstate==0}">
                    <option value="-1">全部</option>
                    <option value="0" selected="selected">临时</option>
                    <option value="1">下单</option>
                    <option value="2">处理中</option>
                    <option value="3">完成</option>
                </c:when>
                <c:when test="${param.orderstate==1}">
                    <option value="-1">全部</option>
                    <option value="0" >临时</option>
                    <option value="1" selected="selected">下单</option>
                    <option value="2">处理中</option>
                    <option value="3">完成</option>
                </c:when>
                <c:when test="${param.orderstate==2}">
                    <option value="-1">全部</option>
                    <option value="0" >临时</option>
                    <option value="1" >下单</option>
                    <option value="2" selected="selected">处理中</option>
                    <option value="3">完成</option>
                </c:when>
                <c:when test="${param.orderstate==3}">
                    <option value="-1">全部</option>
                    <option value="0" >临时</option>
                    <option value="1" >下单</option>
                    <option value="2" >处理中</option>
                    <option value="3" selected="selected">完成</option>
                </c:when>
                <c:otherwise>
                    <option value="-1">全部</option>
                    <option value="0" >临时</option>
                    <option value="1" >下单</option>
                    <option value="2" >处理中</option>
                    <option value="3" >完成</option>
                </c:otherwise>
            </c:choose>
        </select>
        <button type="submit" class="btn">查看</button>
    </form>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>用户昵称</th>
            <th>下单时间</th>
            <th>订单状态</th>
            <th>结账金额</th>
            <th>详细信息</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${p.list}" var="odto">
            <tr>
                <td>${odto.nickname}</td>
                <td>${odto.ordertime}</td>
                <td>
                    <c:choose>
                        <c:when test="${odto.orderstate==0}">临时</c:when>
                        <c:when test="${odto.orderstate==1}">下单</c:when>
                        <c:when test="${odto.orderstate==2}">处理中</c:when>
                        <c:when test="${odto.orderstate==3}">完成</c:when>
                        <c:otherwise>其他</c:otherwise>
                    </c:choose>
                </td>
                <td>${odto.ordertotleprice}</td>
                <td>
                    <%--<a href="${pageContext.request.contextPath }/orders/toedit/${odto.orderid}">编辑</a>--%>
                    <a href="${pageContext.request.contextPath }/orderdetail/list/${odto.orderid}">查看详细信息</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@ include file="/basepage/pager.jsp" %>
</div>


</body>
</html>
