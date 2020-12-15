<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payments</title>
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
		<form action="Report" method="post">
			<fieldset>
				<br />
				<h2 class="topic">Search payments</h2>
				<br />
					<label for="sdate">Start date:</label> <input type="datetime-local"
					name="sdate"> <br /><br />
				 <label for="edate"> End date:</label> <input type="datetime-local"
					name="edate"> <br /><br />
				<br /> <input type="submit" name="action" value="View payment report">
				<br />
				<br />

			</fieldset>
		</form>
		<br />
	</div>
</body>
</html>