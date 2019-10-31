<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
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

<title>left</title>
<script>
	$(function() {
		$(".li1>a").click(function() {
			var mark = $(this).attr("marktag");
			$("[tag='" + mark + "']").toggleClass("close");
			if (!$("[tag='" + mark + "']").hasClass("close")) {
				$("[tag='" + mark + "']").slideDown(500);
			} else {
				$("[tag='" + mark + "']").slideUp(500);
			}
		});
		$(".li1>a").click(function() {
			var mark = $(this).attr("marktag1");
			$("[tag='" + mark + "']").toggleClass("close");
			if (!$("[tag='" + mark + "']").hasClass("close")) {
				$("[tag='" + mark + "']").slideDown(500);
			} else {
				$("[tag='" + mark + "']").slideUp(500);
			}
		})
	});
</script>
</head>
<body>
	<div class="main_left">
		<ul class="breadcrumb">
			<!-- 遍历跟节点 -->
			<dl>
				<c:forEach items="${funlist}" var="fun">
					<c:if test="${fun.funpid==\"-1\"}">
						<li class="li1"><a href="#" marktag="sysmanger">
								<dt datafname="无" dataid="${fun.funid}"
									dataname="${fun.funname}" datafid="-1" dataurl=""
									 onclick="check(this)">${fun.funname}</dt>
						</a></li>
					</c:if>
					<!-- 遍历子节点 -->
					<c:forEach items="${funlist}" var="child">
						<c:if test="${child.funpid==fun.funid}">
							<li>
								<ul class="hidediv" tag="sysmanger">
									<li class="li2"><a
										href="${pageContext.request.contextPath}${child.funurl}"
										target="rightFrame">
											<dd datafname="${child.funpname}" dataid="${child.funid}"
												dataname="${child.funname}" dataurl="${child.funurl}"
												 datafid="${child.funpid}"
												onclick="check(this)">${child.funname}</dd>
									</a></li>
								</ul>
							</li>
						</c:if>
					</c:forEach>
				</c:forEach>
			</dl>
		</ul>
	</div>

</body>
</html>