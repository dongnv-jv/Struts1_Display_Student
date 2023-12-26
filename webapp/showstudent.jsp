<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="form.StudentForm"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.logout {
	background-color: #f44336;
	color: white;
	padding: 5px 18px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 8px;
}

.change {
	display: block;
	justify-content: center;
	text-align: center;
}

.title {
	font-size: 30px;
	background-color: #f44336;
	color: white;
	border-radius: 4px;
	text-align: center;
}
.title2 {
	font-size: 20px;
	background-color: #f44336;
	color: white;
	border-radius: 4px;
	text-align: center;
}
</style>


</head>
<body>

	<%
		StudentForm studentShowById = (StudentForm) request.getAttribute("studentShowById");
	%>
	<br>
	<br>

	<a class="logout" href="changepass.do">Change your Password</a>
	<a class="logout" href="logoutSt.do">Logout</a>

	<br>
	<br>
	<br>
	<div class="title">Student information</div>
	<table class="table table-bordered">
		<thead>
			<tr align="center">
				<th>ID</th>
				<th>Name</th>
				<th>Day of birth</th>
				<th>GPA</th>
				<th>Time of Admission</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=studentShowById.getIdst()%></td>
				<td><%=studentShowById.getName()%></td>
				<td><%=studentShowById.getDayofbirth()%></td>
				<td><%=studentShowById.getGpa()%></td>
				<td><%=studentShowById.getYear()%></td>
			</tr>
		</tbody>
	</table>
	<br>
	<br>

	<%
		if (request.getAttribute("didChange") == "didChange") {
	%>



	<div class="change">
		<form action="changepass.do" method="post">
			<div class="title2">Please enter your password</div><br>
			<input name="pass" type="password" /> <input type="submit"
				values="Change"
				style="border-radius: 8px; background-color: #f44336; color: white;" />
		</form>
	</div>


	<%
		}
	%>

</body>
</html>