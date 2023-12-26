<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="form.StudentForm"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>List Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
.addst {
	display: flex;
	justify-content: center;
}

.title {
	background-color: #f44336;
	color: white;
	border-radius: 4px;
	text-align: center;
	
}

input[type=text] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

.linkbox {
	background-color: #f44336;
	color: white;
	padding: 5px 18px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	border-radius: 8px;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
	margin: 0 auto;
	width: 700px;
}

table th, table td {
	border: 1px solid #ccc;
	padding: 10px;
}

table th {
	background-color: #f3f3f3;
}

@media only screen and (max-width: 700px) {
	div {
		width: 100%;
		overflow-x: auto;
	}
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
	<br>
	<br>
	<br>
	<div>
		<a class="linkbox" href="addStudent.do">Add Student</a> <a
			class="linkbox" href="createUs.do" target="_blank">Create User</a> <a
			class="linkbox" href="logout.do">Log out</a>
	</div>
	<br>
	<br>
	<br>
	<h2 class="title">List Student</h2>
	<%
		ArrayList<StudentForm> List = (ArrayList) request.getAttribute("list");
		String statusDelete = (String) request.getAttribute("statusDelete");
		if (statusDelete != null) {
	%>

	<h4>
		<font color="red">
			<p>Delete Student successfully !</p>
		</font>
	</h4>
	<%
		}
	%>
	<br>

	
	<div align="center">
		<table class="table table-bordered">
			<thead>
				<tr align="center">
					<th>ID</th>
					<th>Name</th>
					<th>Day of birth</th>
					<th>GPA</th>
					<th>Time of Admission</th>
					<th>Delete</th>

				</tr>
			</thead>
			<tbody>
				<%
					if (request.getAttribute("list") != null) {
						for (StudentForm st : List) {
				%>
				<tr align="center">
					<h3>
						<form action="delete.do" method="post">
							<td><%=st.getIdst()%></td>
							<td><%=st.getName()%></td>
							<td><%=st.getDayofbirth()%></td>
							<td><%=st.getGpa()%></td>
							<td><%=st.getYear()%></td>
							<td><input type="hidden" name="delete"
								value="<%=st.getIdst()%>" /> <input type="submit" name="submit"
								value="Delete" />
						</form>
						</td>
					</h3>
				</tr>
			</tbody>
			</form>
			<%
				}
				}
			%>
		</table>
	</div>
	<br>
	<!-- Add Student -->

	<%
		if (request.getAttribute("didDisplayAdd") == "displayAdd") {
	%>
	<h2 class="title">Add Student</h2>
	<br>

	<%
		if (request.getAttribute("statusAdd") == "prepareAdd") {
	%>
	<p style="color: red">Please enter Student information !</p>
	<%
		} else if (request.getAttribute("statusAdd") == "Addsuccess") {
	%>
	<p style="color: red">Add student successfully !</p>
	<%
		} else if (request.getAttribute("statusAdd") == "Addfail") {
	%>
	<p style="color: red">Add student fail !</p>
	<%
		}
	%>
	<div class="addst">


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
			

			<html:submit
				style="border-radius: 8px ; background-color: #f44336;
	color: white;">Add student</html:submit>
		</html:form>
		<br> <br>
	</div>

	<%
		}
	%>


	<br>
	<br>
	<br>
	<br>
	<!-- ________________________________ -->

</body>
</html>