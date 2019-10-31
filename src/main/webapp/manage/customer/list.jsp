<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td>${item.CUSID}</td>
                <td>${item.OPENID}</td>
                <td>${item.NICKNAME}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%--<%@ include file="/basepage/pager.jsp" %>--%>
</div>
</body>
</html>
