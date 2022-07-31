<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<h1 align="center">
		<h2>
		<%
	String err = (String) request.getAttribute("sr");
	%>
		
		<%
			if (err!= null) {	
			%>
			<p>Add Student Fail !</p>
			<%
			}
			%>
		
			<p>Add Student </p>
		</h2>
		<html:form action="addStudent.do" method="post">
			<p>ID Student</p>
			<html:text property="idst" name="student"></html:text>
			<p>Name Student</p>
			<html:text property="name" name="student"></html:text>
			<p>Day of birth (yyyy/mm/dd)</p>
			<html:text property="dayofbirth" name="student"></html:text>
			<p>GPA</p>
			<html:text property="gpa" name="student"></html:text>
			<p>Time of Admission (year)</p>
			<html:text property="year" name="student"></html:text>
				
			<html:submit>Add student</html:submit>			
		</html:form>
			<br>
			<br>
		<br><h2>
		<a href="logout.do">Logout</a>
		</h2>
	</h1>
</body>
</html>