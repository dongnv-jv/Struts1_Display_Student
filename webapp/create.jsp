<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.create {
	display: flex;
	justify-content: center;
}

.title {
	background-color: #f44336;
	color: white;
	border-radius: 4px;
	margin: 8px 0;
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
</style>

</head>
<body>
	<%
		if (session.getAttribute("hasUser") == null) {
	%>
	<meta http-equiv="refresh"
		content="0; url = http://localhost:8080/Struts1_Display_Student/home.do" />
	<%
		}
	%>
	<h1 align="center">
	
	<h2 class="title">Create User</h2>
		<h3>

			<%
				if (request.getAttribute("didCreateUser") != null) {
			%>
			<font color="red">
				<p>Create User fail !</p>
			</font>
			<%
				}
			%>
		</h3>
		
		<div class="create">

			<html:form action="createUser.do" method="post">
				<p>Moi ban nhap User</p>
				<html:text property="name" name="user"></html:text>
				<p>Moi ban nhap Password</p>
				<html:password property="password" name="user"></html:password>
				<html:submit
					style="border-radius: 8px ; background-color: #f44336;
	color: white;">Sign up</html:submit>
			</html:form>
		</div>
		<br> <br> <br>
		<h2>
			<a href="logout.do">Logout</a>
		</h2>

	</h1>
</body>
</html>