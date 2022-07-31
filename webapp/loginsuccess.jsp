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
		
		<a href="addSt.do">Add Student</a>
		<br>
		 <a href="showList.do">Show
			list Student</a><br> 
			<a href="createUs.do"> Create User</a>
	<br> <br> <br>
		<h2>
			<a href="logout.do">Logout</a>
		</h2>
	</h1>
</body>
</html>