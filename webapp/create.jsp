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
		<%
	
		String createUserFail = (String) request.getAttribute("fail");
		%>
		<%
		if (createUserFail != null) {
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
	</h1>
</body>
</html>