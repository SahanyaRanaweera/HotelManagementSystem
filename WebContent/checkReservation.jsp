<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check in</title>
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
		<form action="Reservation" method="post">
			<fieldset>
				<br />
				<h2 class="topic">Guest check in</h2>

				<label for="gnic"> Guest NIC:</label> <input type="text" name="gnic">
				<br />
				<br /> <label for="date"> Date:</label> <input type="datetime-local"
					name="date"> <br />
				<br /> <input type="submit" name="action" value="Check reservation">
				<br />
				<br />

			</fieldset>
		</form>
		<br />
	</div>
</body>
</html>