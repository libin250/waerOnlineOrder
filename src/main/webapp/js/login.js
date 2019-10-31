$("#submit-btn").click(function () {
    var user = $("#user").val();
    if(user==""){
        alert("用户名或密码为空！");
    }else {
        $.ajax({
            async:false;
            type:"POST";


        })
    }


})
