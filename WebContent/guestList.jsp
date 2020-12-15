<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guest list</title>
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
			<h2 class="topic">Guest List</h2>
			<table>
				<tr>
					<th>Guest ID</th>
					<th>Guest name</th>
					<th>Guest phone no</th>
					<th>Guest NIC</th>
					<th>Room No</th>
					<th>Building</th>
					<th>No of Guests</th>
					<th>Reservation ID</th>
				</tr>
				<c:forEach var="res" items="${guest}">
					<tr>
						<td>${res.guestID}</td>
						<td>${res.name}</td>
						<td>${res.phoneNo}</td>
						<td>${res.NIC}</td>
						<td>${res.roomNo}</td>
						<td>${res.buildingNo}</td>
						<td>${res.noOfGuests}</td>
						<td>${res.resID}</td>
					</tr>

				</c:forEach>
			</table>
			<br />
		</fieldset>
		<br />
	</div>
</body>
</html>