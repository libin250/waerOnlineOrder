<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>权限分配t</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
            type="text/javascript"></script>
    <style>
        dt{
            cursor:pointer;
            line-height: 30px;
            font-size: 16px;
        }
        dd{
            cursor:pointer;
            line-height: 25px;
        }
    </style>
    <script type="text/javascript">
        //父节点点击
        function pselect(obj){
            //获取子节点
            var id = obj.id;
            var objs = $("[pid='" + id + "']");
            if ($(obj).attr("checked") == "checked") {
                for (var i = 0; i < objs.length; i++) {
                    //设置全部选中
                    $(objs[i]).attr("checked", "checked");
                }
            } else {
                //取消选中
                for (var i = 0; i < objs.length; i++) {
                    $(objs[i]).removeAttr("checked");
                }
            }
        }
        //子节点点击
        function childselect(obj){
            var pid=$(obj).attr("pid");
            if($(obj).attr("checked")=="checked"){
                $("#"+pid).attr("checked","checked");
            }
        }

        $(document).ready(function () {
            var msg = "${msg}";
            if (msg == "1"){
                alert("保存失败！")
            }else if (msg == "2") {
                alert("保存成功")
            }
        })
    </script>
</head>
<body>
<ul class="breadcrumb">
    <li><a href="${pageContext.request.contextPath}/SysRole/list">角色管理</a> <span class="divider">/</span></li>
    <li class="active">角色权限分配</li>
</ul>

<form action="${pageContext.request.contextPath}/SysRoleFun/distribute" method="post">
    <div class="row-fluid" style="margin-left: 30px">
        <dl >
            <c:forEach items="${funlist}" var="fun">
                <c:if test="${fun.funpid==\"-1\"}">
                    <dt>
                        <c:choose>
                            <c:when test="${!empty(fun.rolefunid)}">
                                <input type="checkbox" name="ids" checked="checked"
                                       id="${fun.funid}" pid="${fun.funpid}" value="${fun.funid}"
                                       onclick="pselect(this);"/>
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" name="ids"
                                       id="${fun.funid}" pid="${fun.funpid}" value="${fun.funid}"
                                       onclick="pselect(this);"/>
                            </c:otherwise>
                        </c:choose>
                            ${fun.funname}
                    </dt>
                </c:if>
                <c:forEach items="${funlist}" var="child">
                    <c:if test="${child.funpid==fun.funid}">
                        <dd>
                            <c:choose>
                                <c:when test="${!empty(child.rolefunid)}">
                                    <input type="checkbox" name="ids" checked="checked" onclick="childselect(this);"
                                           id="${child.funid}" pid="${child.funpid}" value="${child.funid}" />
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox" name="ids" onclick="childselect(this);"
                                           id="${child.funid}" pid="${child.funpid}" value="${child.funid}"/>
                                </c:otherwise>
                            </c:choose>
                                ${child.funname}
                        </dd>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </dl>
        <input type="hidden" id="roleid" name="roleid" value="${roleid}" />
        <input class="btn btn-primary" type="submit" value="保存" />
        <a href="${pageContext.request.contextPath}/SysRole/list"><input type="button" class="btn btn-primary" value="返回"/></a>
    </div>
</form>
</body>
</html>