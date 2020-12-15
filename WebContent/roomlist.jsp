<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room List</title>
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
				<a href="profile.jsp">Profile</a> <a href="Logout">Logout</a>
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
			<h2 class="topic">Room list</h2>
			<table>
				<tr>
					<th>Type id</th>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					
				</tr>
				<tr>
					<th>Type name</th>
					<td>Single</td>
					<td>Double</td>
					<td>Family</td>
				</tr>
				</table>
				<br/>
			<table>
				<tr>
					<th>Room No</th>
					<th>Building No</th>
					<th>Floor No</th>
					<th>Room type</th>
					<th>Status</th>
					<th>AC or No AC</th>
				</tr>
				<c:forEach var="res" items="${roomlist}">
					<tr>
						<td>${res.roomNo}</td>
						<td>${res.buildingNo}</td>
						<td>${res.floorNo}</td>
						<td>${res.typeid}</td>
						<td>${res.status}</td>
						<td>${res.ac}</td>
					</tr>

				</c:forEach>
			</table>
			<br />
			<br />
			
		</fieldset>
		<br />
	</div>

</body>
</html>