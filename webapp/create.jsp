<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<h2>
		
		<%
		if (request.getAttribute("didCreateUser")!=null) {
		%>
		<font color="red">
			<p>Create User fail !</p>
		</font>
		<%
		}
		%>
			<p>Moi ban nhap </p>
		</h2>
		<html:form action="createUser.do" method="post">
			<p>Moi ban nhap User</p>
			<html:text property="name" name="user"></html:text>
			<p>Moi ban nhap Password</p>
			<html:password property="password" name="user"></html:password>
			<html:submit>Sign up</html:submit>
		</html:form>
			<br>
			<br>
		<br><h2>
		<a href="logout.do">Logout</a>
		</h2>
		
	</h1>
</body>
</html>