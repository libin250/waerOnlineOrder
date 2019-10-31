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

<title>后台管理主页</title>
</head>
<frameset rows="50,*" frameborder="no" border="0" framespacing="0" >
	<frame src="${pageContext.request.contextPath}/manage/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset rows="700,*" cols="*" framespacing="0" frameborder="no" border="0">
		<frameset rows="*" cols="280,*" framespacing="0" frameborder="no" border="0">
			<frame src="${pageContext.request.contextPath}/login/initleft" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
			<frame src="${pageContext.request.contextPath}/manage/right.jsp" name="rightFrame"  noresize="noresize" id="rightFrame" title="rightFrame" />
		</frameset>
		<noframes><body>
		</body></noframes>
		</body>
		</html>