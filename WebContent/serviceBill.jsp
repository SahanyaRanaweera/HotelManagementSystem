<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Billing</title>
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
			<h2 class="topic">Guest details</h2>
			<table>
				<tr>
					<th>Room no</th>
					<th>Building no</th>
					<th>Room type</th>
					<th>Room AC</th>
					<th>Room cost</th>
					<th>Service cost</th>
					<th>Total cost</th>
				</tr>
				<tr>
					<td>${room}</td>
					<td>${building}</td>
					<td>${roomType}</td>
					<td>${ac}</td>
					<td>${roomCost}</td>
					<td>${serviceCost}</td>
					<td>${totalCost}</td>
				</tr>

			</table>

			<h2 class="topic">Service List</h2>
			<table>
				<tr>
					<th>Service</th>
					<th>No of orders</th>
					<th>Cost</th>
					<th>Date</th>
				</tr>
				<c:forEach var="res" items="${services}">
					<tr>
						<td>${res.service}</td>
						<td>${res.noOfOrders}</td>
						<td>${res.cost}</td>
						<td>${res.date}</td>
					</tr>
				</c:forEach>
			</table>
			<form action="Payment" method="post">
				<label for="paymethod"> Payment method: </label> <input type="text"
					name="paymethod"> <br />
				<br /> <label for="amount"> Amount: </label> <input type="number"
					step="0.01" name="amount" min="0"> <br />
				<br /> <label for="date"> Departure date and time: </label> <input
					type="datetime-local" name="date"> <br />
				<br /> <input type="hidden" name="room" value="${room}"> <input
					type="hidden" name="building" value="${building}"> <input
					type="submit" name="action" value="Enter payment"> <br />
				<br />
			</form>
		</fieldset>
		<br />
		<br />


	</div>
</body>
</html>