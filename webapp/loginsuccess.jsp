<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>You are Login successfully !</p>
	<h1 align="center">


		<%
		String err = (String) request.getAttribute("ac");
		String del = (String) request.getAttribute("del");
		String createUserFail = (String) request.getAttribute("fail");
		%>

		<%
		if (err != null) {
		%>
		<font color="red">
			<p>Add Student successfully !</p>
		</font>
		<%
		}
		%>
		<%
		if (del != null) {
		%>
		<font color="red">
			<p>Delete Student successfully !</p>
		</font>
		<%
		}
		%>


		<a href="addSt.net">Add Student</a>
		<br>
		 <a href="showList.net">Show
			list Student</a><br> 
			<a href="creatSt.net"> Create User</a>

	</h1>
</body>
</html>