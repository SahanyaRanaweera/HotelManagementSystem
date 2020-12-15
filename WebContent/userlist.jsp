<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User list</title>
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
			<h2 class="topic">User list</h2>
			<table>
			<tr>
				<th>Receptionist</th>
				<td>R </td>
				
			</tr>
			<tr>
			<th>Manager</th>
			<td>M </td>
			</tr>
			</table>
			<table>
				<tr>
					<th>User ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Email</th>
					<th>Phone No</th>
					<th>NIC</th>
					<th>Username</th>
					<th>Title</th>
				</tr>
				<c:forEach var="res" items="${userlist}">
				<tr>
					<td>${res.userID}</td>
					<td>${res.name}</td>
					<td>${res.address}</td>
					<td>${res.email}</td>
					<td>${res.phoneNo}</td>
					<td>${res.NIC}</td>
					<td>${res.username}</td>
					<td>${res.type}</td>
				</tr>
				</c:forEach>
			</table><br/>
			
		</fieldset><br/><br/>
	</div><br/>

</body>
</html>