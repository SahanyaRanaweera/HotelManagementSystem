<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room rates</title>
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
		<form action="Management" method="POST">

			<fieldset>
				<h2 class="topic">Change room rates</h2>

				<label for="type">Room type : </label> <select name="type">
					<option value="">Select one</option>
					<option value="Single">Single</option>
					<option value="Double">Double</option>
					<option value="Family">Family</option>
				</select><br />
				<br /> 
				<label for="price"> Price:</label> <input type="number" step = "0.01" min = "0" 
					name="price"> <br /><br />
					<label for="priceac"> Price for AC:</label> <input type="number" step = "0.01" min = "0" 
					name="priceac"> <br /><br />
				
				 <input type="submit" name="action" value="Set room rate">
				<br />

			</fieldset>
		</form>
		<br /> <br />
		<br />
	</div>
	
</body>
</html>