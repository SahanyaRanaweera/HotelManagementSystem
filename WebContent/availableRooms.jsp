<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Room List</title>
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
			<h2 class="topic">Available rooms</h2>
			<table>
				<tr>
					<th>Room No</th>
					<th>Building No</th>
					<th>Room type</th>
					<th>Status</th>
					<th>AC or No AC</th>
					<th>Price</th>
					<th>Price for AC</th>
				</tr>
				<c:forEach var="res" items="${rooms}">
					<tr>
						<td>${res.roomNo}</td>
						<td>${res.buildingNo}</td>
						<td>${res.type}</td>
						<td>${res.status}</td>
						<td>${res.ac}</td>
						<td>${res.price}</td>
						<td>${res.priceAc}</td>
					</tr>

				</c:forEach>
			</table>
			<br />
			<br />
			<form action="addReservation.jsp" method="post">
				<label for="room">Select room: </label> <input type="number"
					name="room"> <br />
				<br /> <label for="room">Select building: </label> <input
					type="number" name="building"> <br />
				<br /> <input type="hidden" name="type"
					value='<%=request.getParameter("type")%>'> <input
					type="hidden" name="AC" value='<%=request.getParameter("ac")%>'>

				<input type="submit" name="addR" value="Add reservation"> <br />
				<br />
			</form>
		</fieldset>
		<br />
	</div>

</body>
</html>