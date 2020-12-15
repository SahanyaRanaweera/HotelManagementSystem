<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Report</title>
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
			<h2 class="topic">Payment Report</h2>
			<table>
				<tr>
					<th>Payment amount</th>
					<th>Payment date</th>
					<th>Payment method</th>
				</tr>
				<c:forEach var="res" items="${payments}">
				<tr>
					<td>${res.amount}</td>
					<td>${res.date}</td>
					<td>${res.paidMethod}</td>
				</tr>
				</c:forEach>
			</table><br/>
			<table>
			<tr>
				<th>Total payments made during the selected period</th>
			</tr>
			<tr>
				<td>${total}</td>
			</tr>
			</table><br/>
			
		</fieldset><br/><br/>
	</div><br/>
</body>
</html>		