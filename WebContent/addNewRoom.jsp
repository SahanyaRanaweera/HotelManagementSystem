<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rooms</title>
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
				<h2 class="topic">Add new Room</h2>
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
				<br />
				<form action="Management" method="post">
					<label for="room">Room No:</label> <input type="number"
					name="room"> <br /><br />
					<label for="building">Building No:</label> <input type="number"
					name="building"> <br /><br />
					<label for="floor">Floor No:</label> <input type="number"
					name="floor"> <br /><br />
					<label for="type">Room Type id:</label> <input type="number"
					name="type"> <br /><br />
					<label for="status">Room Status:</label> <input type="text"
					name="status"> <br /><br />
				 	<label for="ac">Room AC:</label> <input type="text"
					name="ac"> <br /><br />
				<br /> <input type="submit" name="action" value="Add new Room">
				<br />
				
				</form><br/>
			</fieldset>
		<br />
	</div>
</body>
</html>