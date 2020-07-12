<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<!-- <link type="text/css" rel="stylesheet" href="3.css"> -->
		<title>登录界面</title>
	</head>
	<body>
		<hr size=5 color="#9999ff" width="1500px">
		<img src="img/login01.jpg" style="float:left;">
		<br>
		<br>
		<img src="img/login02.jpg">
		<form name="form01" method="get" action="login">
			<table width="600px" height="100px" border="0">
				<tr>
					<td align=right>用户名：</td>
					<td><input type="text" name="userId"></td>
				<tr>
				<tr>
					<td align="right">密码：</td>
					<td ><input type="password" name="password"></td>
				<tr>
				<tr>
					<td align="right"><input type="submit"></td>
					<td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"></td>
				<tr>
			</table>
		</form>
	</body>
</html>
