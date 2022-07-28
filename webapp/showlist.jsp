<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="form.StudentForm"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Student</title>
</head>
<body>
	<%
	ArrayList<StudentForm> List = (ArrayList) request.getAttribute("list");
	%>

	<h3>Show List dung Interator</h3>
	<table cellspacing="2" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Day of birth</th>
			<th>GPA</th>
			<th>Time of Admission</th>
		</tr>

		<%
		if (request.getAttribute("list") != null) // Null check for the object
		{
			Iterator<StudentForm> iterator = List.iterator(); // Iterator interface

			while (iterator.hasNext()) // iterate through all the data until the last record
			{
				StudentForm st = iterator.next(); //assign individual employee record to the employee class object
		%>
		<tr>
			<td><%=st.getIdst()%></td>
			<td><%=st.getName()%></td>
			<td><%=st.getDayofbirth()%></td>
			<td><%=st.getGpa()%></td>
			<td><%=st.getYear()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h3>Show List dung For each</h3>
	<table cellspacing="2" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Day of birth</th>
			<th>GPA</th>
			<th>Time of Admission</th>
		</tr>
		<%
		if (request.getAttribute("list") != null) // Null check for the object
		{
			for (StudentForm st : List) {
		%>
		<tr>
			<td><%=st.getIdst()%></td>
			<td><%=st.getName()%></td>
			<td><%=st.getDayofbirth()%></td>
			<td><%=st.getGpa()%></td>
			<td><%=st.getYear()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

</body>
</html>