<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>goods_add</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/css/jquery-1.8.1.min.js"
            type="text/javascript"></script>

    <script type="text/javascript">
        <%--保存按钮，验证提交--%>
        function save() {
            if ($("#gname").val().length == 0) {
                $("#msg").html("*请输入菜品名称");
            }
            else if ($("#gimg").val().length == 0) {
                $("#msg").html("*您需要上传图片菜能提交");
            }
            else if ($("#gprice").val().length == 0) {
                $("#msg").html("*请输入菜品价格");
            }
            else if ($("#gcontent").val().length == 0) {
                $("#msg").html("*请输入菜品描述");
            }
            else  if ($("#gtime").val().length == 0) {
                $("#msg").html("*请输入菜品需要需要时间");
            }
            else {
                $.ajax({
                    type:"post",
                    url: "${pageContext.request.contextPath}/goods/ajaxadd",
                    data: {gtid: $("#gtid").val(), gname: $("#gname").val()},
                    success: function (data) {
                        if (data === "t") {
                            $("#msg").html("*该类型的菜品名称已经存在，请重新输入");
                        }
                        else if (data === "f") {
                            window.location.href = "${pageContext.request.contextPath}/goods/add?"+$("#forms").serialize();
                        }
                    }
                })
            }
        }


        <%--添加输入菜品名称后的失焦事件--%>
        function ajaxadd() {
            if($("#gname").val().length>0){
                $.ajax({
                    type:"post",
                    url: "${pageContext.request.contextPath}/goods/ajaxadd",
                    data: {gtid: $("#gtid").val(), gname: $("#gname").val()},
                    success: function (data) {
                        if (data === "t") {
                            $("#msg").html("*该类型的菜品名称已经存在");
                        }
                    }
                })
            }else{
                $("#msg").html("*请输入菜品名称");
            }
        }

        <%--图片上传--%>
        function fileupload() {
            var formData = new FormData();
            formData.append("file",$('#file')[0].files[0]);
                $.ajax({
                    type:"post",
                    url: "${pageContext.request.contextPath}/goods/fileupload",
                    data: formData,
                    cache: false,//文件不设置缓存
                    processData: false,//数据不被转换为字符串
                    contentType: false,//上传文件时使用，避免 JQuery 对其操作
                    success: function (data) {
                        $("#gimg").val(data);
                        $("#msg").html("上传成功");
                    }
                })
        }
    </script>

</head>
<body>
<ul class="breadcrumb">
    <li><a href="#">菜品信息管理</a> <span class="divider">/</span></li>
    <li class="active">添加菜品信息</li>
</ul>

<div class="alert">
    <button type="button" class="close" data-dismiss="alert">×</button>
    <h4>提示!</h4>
    <strong id="msg">${msg}</strong>
</div>
<div class="row-fluid">
    <div class="span12">
        <form class="form-horizontal"
              action=""
              method="post" id="forms">
            <!-- 菜品类型 -->
            <div class="control-group">
                <label class="control-label" for="gtid">菜品类型</label>
                <div class="controls">
                    <select name="gtid" id="gtid">
                        <c:forEach items="${gtlist}" var="item">
                            <option value="${item.gtid}">${item.gtname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <!-- 菜品名称 -->
            <div class="control-group">
                <label class="control-label" for="gname">菜品名称</label>
                <div class="controls">
                    <input type="text" name="gname" id="gname" onblur="ajaxadd()" />
                </div>
            </div>

            <!-- 菜品图片 -->
            <div class="control-group">
                <label class="control-label" for="gimg">菜品图片</label>
                <div class="controls">
                    <input type="file" name="file" id="file"/>
                    <input type="hidden" name="gimg" id="gimg"/>
                </div>
                <div class="controls">
                    <input type="button" value="上传" onclick="fileupload()"/>
                </div>
            </div>


            <!-- 菜品价格-->
            <div class="control-group">
                <label class="control-label" for="gprice">菜品价格</label>
                <div class="controls" >
                    <input type="text" name="gprice" id="gprice" />
                </div>
            </div>


            <!-- 菜品描述 -->
            <div class="control-group">
                <label class="control-label" for="gcontent">菜品描述</label>
                <div class="controls">
                   <textarea rows="5" cols="40" class="ckeditor" name="gcontent" id="gcontent">
                       ${goods.gcontent}
                   </textarea>
                </div>
            </div>



            <!-- 需要时间 -->
            <div class="control-group">
                <label class="control-label" for="gtime">需要时间</label>
                <div class="controls">
                    <input type="text" name="gtime" id="gtime" />
                </div>
            </div>

            <!-- 状态-->
            <div class="control-group">
                <label class="control-label" for="gstate">状态</label>
                <div class="controls">
                    <select name="gstate" id="gstate">
                        <option value="1">可用</option>
                        <option value="0">不可用</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <input type="button" class="btn" value="保存"
                           onclick="save();" />
                    <button class="btn btn-primary" type="button"
                            onclick="window.location.href='${pageContext.request.contextPath}/goods/list';">返回</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>