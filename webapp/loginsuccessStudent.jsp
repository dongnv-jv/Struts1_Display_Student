<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">
		Welcome &nbsp
		<bean:write name="student" property="name" />
		&nbsp
		<bean:write name="student" property="idst" />
	</h1>

	<h2>
		<a href="changeSt.do">Change your Password</a><br>
		<br> <a href="showStudent.do">Display your Information</a>
	</h2>
</body>
</html>