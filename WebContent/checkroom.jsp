<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check rooms</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<% String uname = (String)session.getAttribute("user");%>
	<header>
		<div class="dropdown">
			<h2 class="user"><%= uname %></h2>
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
		<form action="Reservation" method="POST">

			<fieldset>
				<h2 class="topic">Search available rooms</h2>

				<label for="type">Room type : </label> <select name="type">
					<option value="">Select one</option>
					<option value="Single">Single</option>
					<option value="Double">Double</option>
					<option value="Family">Family</option>
				</select><br />
				<br /> <label>AC status: </label> <input type="radio" id="ac"
					name="ac" value="AC" required> <label for="ac">AC </label>
				<input type="radio" id="noAc" name="ac" value="No AC" required>
				<label for="noAc">No AC </label><br />
				<br /> <input type="submit" name="action" value="Search rooms">
				<br />
				<br />

			</fieldset>
		</form>
		<br /> <br />
		<br />
	</div>

</body>
</html>