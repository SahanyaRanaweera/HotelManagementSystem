<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add reservation</title>
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
				<br />
				<h2 class="topic">Add new Reservation</h2>
				<% 
					   String error = (String)session.getAttribute("error");
					   if (error == null){
						   error = " ";
				  	   }
			        %>
				<h3><%= error %></h3>

				<input type="hidden" name="roomNo"
					value='<%=request.getParameter("room")%>'> <input
					type="hidden" name="building"
					value='<%=request.getParameter("building")%>'> <input
					type="hidden" name="type" value='<%=request.getParameter("type")%>'>
				<input type="hidden" name="AC"
					value='<%=request.getParameter("AC")%>'> <label for="gname">
					Name:</label> <input type="text" name="gname"> <br />
				<br /> <label for="email"> Email: </label> <input type="text"
					name="email"> <br />
				<br /> <label for="phone"> Phone No: </label> <input type="text"
					name="phone"> <br />
				<br /> <label for="nic"> NIC: </label> <input type="text" name="nic">
				<br />
				<br /> <label for="guests"> No of Guests: </label> <input
					type="number" name="guests" min="1"> <br />
				<br /> <label for="arrival"> Arrival date and time: </label> <input
					type="datetime-local" name="arrival"> <br />
				<br /> <label for="departure"> Departure date and time: </label> <input
					type="datetime-local" name="departure"> <br />
				<br /> <input type="submit" name="action"
					value="Add new reservation"> <br />
				<br />
			</fieldset>
		</form>
		<br />
	</div>
</body>
</html>