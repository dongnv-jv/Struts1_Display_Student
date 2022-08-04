<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("isLoggedIn") == null) {
	%>
	<meta http-equiv="refresh"
		content="0; url = http://localhost:8080/Struts1_Display_Student/home.do" />
	<%
		}

		if (request.getAttribute("statusChange") != null) {
	%>
	<h2>
		<font color="red">
			<p>Delete Student Fail !</p>
		</font>
	</h2>
	<%
		}
	%>

	<h1 align="center">
		<form action="changepass.do" method="post">
			<p>Moi ban nhap Password</p>
			<input name="pass" type="password" /><br> <input type="submit"
				values="Change" />
		</form>

		<br> <br>
		<h2>
			<a href="logoutSt.do">Logout</a>
		</h2>
	</h1>
</body>
</html>