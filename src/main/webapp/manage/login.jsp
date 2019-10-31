<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录页面</title>
</head>

<%--<script type="text/javascript" src="statics/js/jquery-3.3.1.js"></script>--%>

<%--<script type="text/javascript">--%>

    <%--function userLogin(){--%>
        <%--$.ajax({--%>
            <%--type : "post",--%>
            <%--url : "checkLogin",--%>
            <%--dataType:"json",--%>
            <%--data:{--%>
                <%--username:$("#username").val(),--%>
                <%--password:$("#password").val()--%>
            <%--},--%>
            <%--success : function(data) {--%>
                <%--if(data.code == "0"){--%>
                    <%--window.location.href = "/test.jsp";--%>
                <%--}else {--%>
                    <%--alert(data.errorInfo+"");--%>
                    <%--$("#showMessage").val(data.errorInfo+"");--%>
                <%--}--%>
            <%--}--%>
        <%--});--%>
    <%--}--%>
<%--</script>--%>
<body>

<div align="center">
    <form action="${pageContext.request.contextPath}/login/login" method="post">
        <textarea id="showmsg" style="border:none;"></textarea>
        <p>用户登录</p>
        账号：<input name="username" type="text" />
        <br><br>
        密码：<input name="userpwd" type="password" />
        <br><br>
        <input type="reset" value="撤 销" />
        <input type="submit" id="submit-btn" name="submit-btn" value="提 交" />
    </form>
</div>

</body>
</html>