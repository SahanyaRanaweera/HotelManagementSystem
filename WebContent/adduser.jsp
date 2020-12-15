<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new user</title>
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
		<form action ="User" method ="post">
		<fieldset>
			<br />
			<h2 class="topic">Add new user</h2>
			<label for="name">Name:</label> <input type="text"
					name="name"> <br /><br />
			<label for="address">Address:</label> <input type="text"
			name="address"> <br /><br />
			<label for="email">Email:</label> <input type="text"
					name="email"> <br /><br />
			<label for="phone">Phone:</label> <input type="text"
					name="phone"> <br /><br />
			<label for="nic">NIC:</label> <input type="text"
					name="nic"> <br /><br />
			<label for="uname">Username:</label> <input type="text"
					name="uname"> <br /><br />
			<label for="pwd">Password:</label> <input type="text"
					name="pwd"> <br /><br />
			<label for="type">User type : </label> <select name="type">
					<option value="">Select one</option>
					<option value="R">R (Receptionist)</option>
					<option value="M">M (Manager)</option>
				</select><br />		
			<input type="submit" name="action" value="Add user">
				<br />					
		</fieldset>
		</form><br/><br/>
	</div>		
</body>
</html>