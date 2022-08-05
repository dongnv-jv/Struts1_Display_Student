<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
.box0 {
	display: flex;
	justify-content: center;
}

.box1 {
	background-color: lightgrey;
	width: 300px;
	border: 1px solid green;
	padding: 100px;
	margin: 20px;
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}

input[type=text], [type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 100%;
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.box2 {
	text-align: center;
}

.form {
	width: 100%;
	padding: 12px 20px;
	margin: auto ;
	box-sizing: border-box;
	border-radius: 8px;
}
</style>
</head>
<body>
	<%
		String opption = (String) request.getAttribute("checklogin");
	%>

	<div class="box0">
		<div class="box1">
			<div class="box2">
				<div>
					<img style="width: 100px;" alt="POSTMART"
						src="https://hanhtrinhmouoc2018.thanhnien.vn/img/general/none-avatar.png">
				</div>

				<div>
					<%
						if (request.getAttribute("didLogin") != null || request.getAttribute("didLoginSt") != null) {
					%>
					<font color="red">
						<p align="center">The Username or Password is Incorrect !</p> <br>
					</font>
					<%
						}
					%>
				</div>
				<div>
					<form action="checklogin.do" method="post" >
						<input type="hidden" name="Admin" value="Admin" />
						<button class="form">Login with Admin</button>
						&ensp;
					</form>


					<form action="checklogin.do" method="get">
						<input type="hidden" name="Admin" value="Student" />
						<button class="form">Login with Student</button>
					</form>

				</div>
			</div>
			<%
				if (opption == "Admin") {
			%>
			<html:form action="login.do" method="post">
				<p style="color: red" align="center">You are logging in with Admin</p>
				<p>Name</p>
				<html:text property="name" name="user" />
				<p>Pasword</p>
				<html:password property="password" name="user" />
				<html:submit>LOG IN</html:submit>
			</html:form>
			<%
				} else if (opption == "Student") {
			%>
			<html:form action="loginSt.do" method="post">
				<p style="color: red" align="center">You are log in with Student</p>
				<p>Name</p>
				<html:text property="idst" name="student"></html:text>
				<p>Pasword</p>
				<html:password property="password" name="student"></html:password>
				<html:submit>LOG IN</html:submit>
			</html:form>
			<%
				}
			%>

		</div>
	</div>
</body>
</html>