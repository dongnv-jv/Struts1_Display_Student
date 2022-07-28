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
	<br>
	<br>
	<br>
	<h1 align="center">
		<h2>
			<p>Moi ban nhap tai khoan Student</p>
		</h2>
		<html:form action="loginst.net" method="post">
			<p>Moi ban nhap User</p>
			<html:text property="idst" name="student"></html:text>
			<p>Moi ban nhap Password</p>
			<html:password property="password" name="student"></html:password>
			<html:submit>Submit</html:submit>
		</html:form>
	</h1>
</body>
</html>