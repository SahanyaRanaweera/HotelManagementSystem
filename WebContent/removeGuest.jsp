<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<br /> 
		<form action = "Guest" method = "post">
		<fieldset>
			<br />
			<label for="room"> Room No: </label> <input type="number"
					name="room"> <br />
				<br /> <label for="building"> Building No: </label> <input
					type="number" name="building"> <br />
				<br />
			
			 <input type="submit" name="action" value="Remove guest">
				<br />
				<br />
		</fieldset><br />
		</form>
	</div>		
</body>
</html>