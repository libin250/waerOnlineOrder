<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>goodsType_edit</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
            type="text/javascript"></script>
    <script type="text/javascript">
        var checkform = function(){
            if($("#gtname").val().length==0) {
                $("#msg").html("*请输入类型名称");
            }else{
                $.ajax({
                    type:"post",
                    url:"${pageContext.request.contextPath}/goodstype/ajaxedit",
                    data:{gtname:$("#gtname").val(),gtid: $("#gtid").val()},
                    success:function (data){
                        if(data==="t"){
                            $("#msg").html("*该类型名称已经存在");
                        }
                        if(data==="f"){
                            window.location.href="${pageContext.request.contextPath}/goodstype/edit?"+$("#forms").serialize();

                        }
                    }
                })
            }
        }
    </script>
</head>
<body>
<ul class="breadcrumb">
    <li><a href="#">菜品类型管理</a> <span class="divider">/</span></li>
    <li class="active">修改菜品类型</li>
</ul>
<div class="alert">
    <button type="button" class="close" data-dismiss="alert">×</button>
    <h4>提示!</h4>
    <strong id="msg">${msg}</strong>
</div>
<div class="row-fluid">
    <div class="span12">
        <form class="form-horizontal"
              action="${pageContext.request.contextPath}/goodstype/edit"
              method="post" id="forms">
            <div class="control-group">
                <label class="control-label" for="gtname">类型名称</label>
                <div class="controls">
                    <input id="gtname" value="${gtype.gtname}" type="text" name="gtname" maxlength="20" />
                    <input type="hidden" id="gtid" name="gtid" value="${gtype.gtid}" />
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="gtstate">类型状态</label>
                <div class="controls">
                    <select name="gtstate" id="gtstate">
                        <c:choose>
                            <c:when test="${gtype.gtstate==1}">
                                <option value="1" selected="selected">可用</option>
                                <option value="0">不可用</option>
                            </c:when>
                            <c:otherwise>
                                <option value="1">可用</option>
                                <option value="0" selected="selected">不可用</option>
                            </c:otherwise>
                        </c:choose>

                    </select>
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <input type="button" class="btn" value="保存"
                           onclick="return checkform();" />
                    <button class="btn btn-primary" type="button"
                            onclick="window.location.href='${pageContext.request.contextPath}/goodstype/list';">返回</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
