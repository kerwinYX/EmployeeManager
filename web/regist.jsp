<%--
  Created by IntelliJ IDEA.
  User: Kerwin
  Date: 2019/10/03
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>注册成为会员</title>
	<link rel="stylesheet" type="text/css" href="css/regist.css">
	<script src="js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="js/regist.js"></script>

</head>
<body>
<div class="regist-wrapper">
	<div class="d1">
		<h1>欢迎注册</h1>
		<form action="regist" method="post">
			<%--用户名称：<input id="username" type="text" name="username" onfocus="usernameFocus()" onblur="checkUsername()">--%>
			用户名称：<label for="username"></label><input type="text" id="username" name="username">
			<br>
			用户密码：<label for="password"></label><input type="password" id="password" name="password"><br>
			确认密码：<label for="repassword"></label><input type="password" id="repassword" name="repassword"><br>
			<div class="dd1">
				<input type="submit" id="submit" value="注册" style="font-size: 16px">
			</div>
		</form>
		<div class="prompt">
		<span id="regist_error">&nbsp;</span>
			<br>
			<br>
			<br>
		<span id="passSpan">&nbsp;</span>
		</div>
	</div>
</div>
</body>
</html>
