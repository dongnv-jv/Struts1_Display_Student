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
	<h1 align="center">
		<h2>
			<p>Moi ban nhap tai khoan</p>
		</h2>
		<html:form action="login.net" method="post">
			<p>Moi ban nhap User</p>
			<html:text property="name" name="user"></html:text>
			<p>Moi ban nhap Password</p>
			<html:password property="password" name="user"></html:password>
			<html:submit>Submit</html:submit>
		</html:form>
	</h1>

	<h2 align="center">
		<a href="createuser.net"> Tao tai khoan</a>

	</h2>

</body>
</html>