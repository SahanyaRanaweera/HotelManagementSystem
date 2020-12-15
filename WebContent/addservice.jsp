<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
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
		<form action="Service" method="post">
			<fieldset>
				<br />
				<h2 class="topic">Add services</h2>
				<label for="room"> Room No: </label> <input type="number"
					name="room"> <br />
				<br /> <label for="building"> Building No: </label> <input
					type="number" name="building"> <br />
				<br /> <label for="serviceName"> Service Name: </label> <input
					type="text" name="serviceName"> <br />
				<br /> <label for="noOfOrders"> No of orders: </label> <input
					type="text" name="noOfOrders"> <br />
				<br /> <label for="sdate"> Service date: </label> <input
					type="datetime-local" name="sdate"> <br />
				<br /> <input type="submit" name="sbmt" value="Add service">
				<br />
				<br />
			</fieldset>
		</form><br/>
	</div>
</body>
</html>
