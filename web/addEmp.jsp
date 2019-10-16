<%--
  Created by IntelliJ IDEA.
  User: Kerwin
  Date: 2019/10/10
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>添加员工</title>
	<script src="js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>

	<script>

		$(function () {
			$("#submit").click(function () {

            })
        })
	</script>
</head>
<body>
<div id="addEmp">
	<form action="addEmp" method="post">
		lastName：<input type="text" id="lastName" name="lastName"><br>
		email：<input type="text" id="email" name="email"><br>
		gender：<input type="radio" name="gender" value="0">女
		<input type="radio" name="gender" value="1">男<br>
		deptName：<select id=""deptName name="deptName">
		<option value="1">人事部</option>
		<option value="2">销售部</option>
		<option value="3">教学部</option>
	</select>
		<div class="dd1">
			<input type="submit" id="submit" value="添加" style="font-size: 16px">
		</div>
	</form>

</div>
</body>
</html>
