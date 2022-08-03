<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="form.StudentForm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	StudentForm studentShowById = (StudentForm) request.getAttribute("studentShowById");
	%>
	<br> <br> <br>
		<h2>
			<a href="logoutSt.do">Logout</a>
		</h2>
	<table cellspacing="2" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Day of birth</th>
			<th>GPA</th>
			<th>Time of Admission</th>
		</tr>

		<tr>
			<td><%=studentShowById.getIdst()%></td>
			<td><%=studentShowById.getName()%></td>
			<td><%=studentShowById.getDayofbirth()%></td>
			<td><%=studentShowById.getGpa()%></td>
			<td><%=studentShowById.getYear()%></td>
		</tr>
	</table>

</body>
</html>