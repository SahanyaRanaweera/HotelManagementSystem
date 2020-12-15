<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<header>
		<h1>Hotel Wizard</h1>
	</header>
	<hr />
	<br />
	<div id="back">
		<br />

		<form action="log" method="POST">

			<fieldset>
				<h2 class="topic">Login</h2>
				<%
					String error = (String) session.getAttribute("error");
				if (error == null) {
					error = " ";
				}
				%>
				<h3><%=error%></h3>
				<label for="uname"> Username:</label> <input type="text"
					name="uname" autocomplete="off"> <br />
				<br /> <label for="pwd"> Password: </label> <input type="password"
					name="pwd" autocomplete="off"> <br />
				<br /> <input type="submit" name="sbmt" value="Log in"> <br />
				<br />

			</fieldset>
		</form>
		<br /> <br />
		<br />
	</div>

</body>
</html>