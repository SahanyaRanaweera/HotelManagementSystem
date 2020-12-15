<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservations</title>
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
				to dashboard</button></a><br /> <br />
		<fieldset>
			<br />
			<h2 class="topic">Reservation List</h2>
			<table>
				<tr>
					<th>Reservation ID</th>
					<th>Guest name</th>
					<th>Guest NIC</th>
					<th>Guest phone no</th>
					<th>Room type</th>
					<th>AC or No AC</th>
					<th>No of Guests</th>
					<th>Arrival Date</th>
				</tr>
				<c:forEach var="res" items="${reservation}">
					<tr>
						<td>${res.id}</td>
						<td>${res.guestName}</td>
						<td>${res.nic}</td>
						<td>${res.phone}</td>
						<td>${res.roomType}</td>
						<td>${res.AC}</td>
						<td>${res.noOfGuests}</td>
						<td>${res.arrivalDate}</td>
					</tr>
					<c:set var="nic" value="${res.nic}" />
					<c:set var="date" value="${res.arrivalDate}" />
				</c:forEach>
			</table>
			<br />

			<%
				String checkin = (String) session.getAttribute("checkin");
			if (checkin == null) {
				checkin = " ";
			}
			%>
			<c:set var="check" value="${checkin}" />
			<c:set var="checkval" value="yes" />
			<c:if test="${check eq checkval}">
				<form action="Reservation" method="POST">
					<input type="hidden" name="gnic" value="${nic}"> <input
						type="hidden" name="adate" value="${date}">
					<button name="action" type="submit" value="Cancel reservation" class="button">Cancel
						reservation</button>
				</form>
				<br />
				<form action="Guest" method="POST">
					<input type="hidden" name="gnic" value="${nic}"> <input
						type="hidden" name="adate" value="${date}">
					<button name="action" type="submit" value="Add new guest" class="button">Add new guest
					</button>
				</form>
				<br />
				<br />
			</c:if>
		</fieldset>
		<br />
	</div>
</body>
</html>