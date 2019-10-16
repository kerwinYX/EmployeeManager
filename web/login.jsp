<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<head>
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<script type="text/javascript" src="js/login.js"></script>
	<title>登录界面</title>
</head>
<body>
<div class="login-wrapper">
	<div class="d1">
		<h1>欢迎登录</h1>
		<form action="login" method="post">
			用户名称：<input id="t_user" type="text" name="username" onfocus="testFocus()">
			<br><br>
			用户密码：<input type="password" name="password"><br>
			<div class="dd1">
				<input type="submit" value="登录" style="font-size: 16px">
				<a href="regist.jsp">注册</a>
				<a href="">忘记密码</a>
			</div>
		</form>
		<div class="prompt">
			<%--<%
				//request对象不需要获取  可以直接用
				//在jsp中,九大对象都能够直接用 不需要进行获取
				//获取在servlet中set的
				// req.setAttribute("login_Msg", "用户名或密码错误")得到
				String login_msg = (String) request.getAttribute("login_Msg");

			%>
			<span><%= login_msg == null ? "" : login_msg %></span>--%>

			<%--EL表达式  默认会从pagescope requestscope sessionscope applicationscope中查找数据--%>
			<span id="s_error">${requestScope.login_Msg}</span>
		</div>
	</div>
</div>


</body>
</html>