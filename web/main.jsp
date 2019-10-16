<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>首页</title>
	<script src="http://code.jquery.com/jquery-2.1.4.min.js" type="text/javascript" charset="utf-8"></script>
	<style>
		body {
			padding: 0px;
			margin: 0px;
		}

		#d1 #count {
			color: red;
			font-size: 17px;
		}

		#d1 {
			background-image: url("image/pan.jpg");
			height: 50px;
			/*position: absolute;*/
		}

		#welcome {
			margin-left: 10px;
			margin-top: 5px;
			color: red;
			text-align: center;
			float: left;
			font-size: 30px;

		}

		#header-right {
			float: right;
			margin-top: 5px;
			margin-right: 9px;
			height: 40px;
		}

		#d2 {
			background-color: beige;
		}

		#d2 tr {
			text-align: center;
		}

		#add {
			text-align: center;
		}

		#under{
			text-align: center;
		}
	</style>


	<script>

        <%--$(function () {--%>
        <%--alert("asa");--%>
        <%--var emps = JSON.parse(${requestScope.s});--%>

        <%--var str = "<tr><th>ID</th><th>LastName</th><th>email</th><th>gender</th><th>deptName</th><th>Operation</th></tr>>"--%>
        <%--for (var i = 0; i < emps.length; i++) {--%>
        <%--var emp = emps[i];--%>
        <%--// console.log(emp.id);--%>
        <%--str += "<tr><td>" + emp.id + "</td><td>" + emp.lastName + "</td><td>"--%>
        <%--+ emp.email + "</td><td>" + (emp.gender == 0 ? "女" : "男")--%>
        <%--+ "</td><td>" + emp.department.deptName + "</td><td><a href=\"modifyEmp.jsp\">修改</a><a href=\"delete\">删除</a></td></tr>";--%>
        <%--}--%>
        <%--&lt;%&ndash;alert("欢迎！ ${sessionScope.username_Msg}");&ndash;%&gt;--%>
        <%--// $.ajax({--%>
        <%--//     url: "showCount",--%>
        <%--//     type: "get",--%>
        <%--//     success: function (data) {--%>
        <%--//         // console.log(data);--%>
        <%--//         $("#count").html("当前在线人数：" + data);--%>
        <%--//     }--%>
        <%--// });--%>



        <%--$("#emptable").html(str);--%>


        <%--$("#next_page").click(function () {--%>

        <%--});--%>
        <%--$("#last_page").click(function () {--%>

        <%--});--%>
        <%--$("#end_page").click(function () {--%>

        <%--})--%>

        <%--// $.ajax({--%>
        <%--//     type: "post",--%>
        <%--//     url: "getEmpsByJSON",--%>
        <%--//     datatype: "json",--%>
        <%--//     success: function (data) {--%>
        <%--//         var  emps = JSON.parse(data);--%>
        <%--//         var str = "<tr><th>ID</th><th>LastName</th><th>email</th><th>gender</th><th>deptName</th><th>Operation</th></tr>>"--%>
        <%--//         for (var i = 0; i < emps.length; i++) {--%>
        <%--//             var emp = emps[i];--%>
        <%--//             // console.log(emp.id);--%>
        <%--//--%>
        <%--//             str += "<tr><td>" + emp.id + "</td><td>" + emp.lastName + "</td><td>"--%>
        <%--// 				+ emp.email + "</td><td>" + (emp.gender == 0 ? "女" : "男")--%>
        <%--// 				+ "</td><td>" + emp.department.deptName + "</td><td><a href=\"modifyEmp.jsp\">修改</a><a href=\"delete\">删除</a></td></tr>";--%>
        <%--//         }--%>
        <%--//         $("#emptable").html(str);--%>
        <%--//     }--%>
        <%--// });--%>


        <%--// $("#delete").click(function () {--%>
        <%--//     alert("delete");--%>
        <%--// 	$("#table-Emp").remove();--%>
        <%--// })--%>
        <%--})--%>
$(function () {
    $("#cc").click(function () {
        var click = $("#change").val();
        $("#cc").attr("href","page?page="+click);
    });

    $("#delete").bind("click",function () {
        var a = confirm("删除员工？？");
        if (a) {
            alert("删除成功！！");
            return a;
		}else {
            return a;
		}

    });

	$("#add").click(function () {
	    alert("添加成功！！！")
    });


})





	</script>
</head>
<body>
<%--<span id="count">当前在线人数：${applicationScope.count}</span>--%>
<div id="d1">
	<span id="welcome">欢迎  <span style="color:lightseagreen;">${sessionScope.username_Msg}</span></span>
	<div id="header-right">
		<span id="count">在线人数：${applicationScope.count}</span>
		<a href="exit">登出</a>
	</div>

</div>
<br>
<br>
<br>
<div id="d2">
	<h2 align="center">员工信息表</h2>
	<table id="emptable" border="1px" width="70%" cellspacing="0px" align="center">
		<c:if test="${!empty requestScope.emps}">
			<table border="1px" width="70%" align="center" cellspacing="0px">
				<tr>
					<th>ID</th>
					<th>LastName</th>
					<th>Email</th>
					<th>gender</th>
					<th>DeptName</th>
					<th>Operation</th>
				</tr>
					<%--通过循环显示员工数据--%>
				<c:forEach items="${requestScope.emps}" var="emp">
					<tr align="center" id="table-Emp">
						<td>${emp.id}</td>
						<td>${emp.lastName}</td>
						<td>${emp.email}</td>
						<td>${emp.gender==0?"女":"男"}</td>
						<td>${emp.department.deptName}</td>
						<td>
								<%--<a href="#">Edit</a>&nbsp;&nbsp;--%>
							<a href="delete?id=${emp.id}" id="delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty requestScope.emps}">
			<h2 align="center">暂无数据</h2>
		</c:if>


	</table>
</div>
<div id="under">
	<span>总页数：${requestScope.pageCount}</span>
	<a href="page?page=1">首页</a>
	<c:if test="${requestScope.page>1}">
		<a id="last_page" href="page?page=${requestScope.page-1}">上一页</a>
	</c:if>
	<c:if test="${requestScope.pageCount != requestScope.page}">
		<a id="next_page" href="page?page=${requestScope.page+1}">下一页</a>
	</c:if>

	<a id="end_page" href="page?page=${requestScope.pageCount}">尾页</a>
	跳转到<input id="change" type="text">页 <a id="cc" href="page?page=">跳转</a>
	<a id="add" href="addEmp.jsp">
		<button>添加员工</button>
	</a>
</div>


</body>
</html>
