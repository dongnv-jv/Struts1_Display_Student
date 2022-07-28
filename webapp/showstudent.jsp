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
	StudentForm st = (StudentForm) request.getAttribute("st");
	%>

	<table cellspacing="2" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Day of birth</th>
			<th>GPA</th>
			<th>Time of Admission</th>
		</tr>

		<tr>
			<td><%=st.getIdst()%></td>
			<td><%=st.getName()%></td>
			<td><%=st.getDayofbirth()%></td>
			<td><%=st.getGpa()%></td>
			<td><%=st.getYear()%></td>
		</tr>
	</table>

</body>
</html>