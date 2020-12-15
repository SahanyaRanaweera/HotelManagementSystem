<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<%
		String uname = (String) session.getAttribute("user");
	%>
	<header>
		<div class="dropdown">
			<h2 class="user"><%=uname%></h2>
			<div class="types">
				<a href="#">Profile</a> <a href="Logout">Logout</a>
			</div>
		</div>

		<h1>Hotel Wizard</h1>
	</header>
	<hr />
	<br />
	<div id="back">
		<br /> <a href="dashboard.jsp"><button name="dash" class="button">Back
				to dashboard</button></a><br />
		<br />
		<fieldset>
			<br />
			<h2 class="topic">My Profile</h2>
			<table>
				<tr>
					<td>User ID</td>
					<td><c:out value="${id}"></c:out></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><c:out value="${name}" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><c:out value="${address}" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><c:out value="${email}" /></td>
				</tr>
				<tr>
					<td>Phone No</td>
					<td><c:out value="${phone}" /></td>
				</tr>
				<tr>
					<td>NIC</td>
					<td><c:out value="${nic}" /></td>
				</tr>
				<tr>
					<td>Position</td>
					<td><c:out value="${title}" /></td>
				</tr>

			</table>
		</fieldset>
		<br />
	</div>


</body>
</html>