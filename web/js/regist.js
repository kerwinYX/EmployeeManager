//使用jQuery
$(function () {
    var usernameFlag = false;
    var passwordFlag = false;

    $("#username").focus(function () {
        $("#regist_error").html("");
    });

    $("#username").blur(function () {
        var  username = $("#username").val();
        //发送异步请求
        if (username === ""){
            $("#regist_error").html("用户名不能为空");
        } else {
            $.ajax({
                    url: "CheckUsername",
                    type: "get",
                    data: "username=" + username,
                    //会自动获取服务器返回的数据  data
                    success: function (data) {
                        if (data == 0) {
                            $("#regist_error").html("该用户名不可用");
                        } else {
                            $("#regist_error").html("该用户名可用");
                            usernameFlag = true;
                        }
                    }
                }
            )
        }
    });

    $("#repassword").blur(function () {
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if (password !== "" && repassword !== "" && password === repassword) {
            $("#passSpan").html("密码一致");
            passwordFlag = true;
        }else {
            $("#passSpan").html("密码不一致");
        }
    });

    $("form").submit(function () {

      return passwordFlag && passwordFlag

    });



});


// //异步请求对象
// function getXMLHttpRequest() {
//     var xhr;
//     xhr = new XMLHttpRequest();
//     return xhr;
// }
//
// //Get请求使用
// function checkUsername(){
//     var xhr = getXMLHttpRequest();
//     //获取用户输入的用户名
//     var userName = document.getElementById("username").value;
//
//     //设置请求信息
//     xhr.open("get","CheckUsername?username="+userName,true);
//     //发送请求
//     xhr.send();
//     //监听readyState的状态
//     xhr.onreadystatechange=function () {   //匿名函数
//         if (xhr.readyState === 4){           //响应处理完成
//             if (xhr.status === 200){         //如果处理正确
//                 //获取服务端响应回来的数据 并设置页面
//                 var checkSpan = document.getElementById("regist_error");
//                 checkSpan.innerHTML = xhr.responseText;
//
//
//             }
//         }
//     }
// }
//
// //post请求使用
// function checkUsername1(){
//     var xhr = getXMLHttpRequest();
//     //获取用户输入的用户名
//     var userName = document.getElementById("username").value;
//
//     //设置请求信息
//     xhr.open("post","regist.jsp",true);
//     //设置请求头
//     xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
//     //发送请求
//     xhr.send("username="+userName);
//     //监听readyState的状态
//     xhr.onreadystatechange=function () {   //匿名函数
//         if (xhr.readyState === 4){           //响应处理完成
//             if (xhr.status === 200){         //如果处理正确
//                 //获取服务端响应回来的数据 并设置页面
//                 var checkSpan = document.getElementById("regist_error");
//                 checkSpan.innerHTML = xhr.responseText;
//
//
//             }
//         }
//     }
// }