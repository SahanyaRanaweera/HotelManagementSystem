<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<c:forEach var="userDetails" items="${userDetails}">
		<c:set var="id" scope="session" value="${userDetails.userID}" />
		<c:set var="name" scope="session" value="${userDetails.name}" />
		<c:set var="email" scope="session" value="${userDetails.email}" />
		<c:set var="phone" scope="session" value="${userDetails.phoneNo}" />
		<c:set var="address" scope="session" value="${userDetails.address}" />
		<c:set var="nic" scope="session" value="${userDetails.NIC}" />
	</c:forEach>
	<c:set var="title" scope="session" value="${title}" />

	<%
		session.setAttribute("checkin", "no");
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
		<fieldset>
			<br />
			<h2 class="topic">Welcome!</h2>
			<div class="right">
			<a href="addservice.jsp"><button name="addService" class="button">Add
					Services</button></a> <a href="checkout.jsp"><button
					name="checkOut" class="button">Guest Check Out</button></a><br /> <br />
					</div>
			<div>
			<a href="checkroom.jsp"><button name="checkRoom" class="button">Search
					rooms</button></a>
			<form action="Reservation" method="POST" class="dash">
				<button name="action" type="submit" value="View Reservations"
					class="button">View Reservations</button>
			</form>
			<a href="checkReservation.jsp"><button
					name="check" class="button">Check reservation</button></a>	 
				</div>	
			
			
			<c:set var="checkval" value="Manager" />
			<c:set var="checkval1" value="Owner" />
			<c:choose>
			<c:when test="${title eq checkval || title eq checkval1}">
			<hr/>
				<div class ="right">
				<a href="removeGuest.jsp"><button name="remove" class="button">Remove
						guest</button></a>
				
				<a href="addNewService.jsp"><button name="newservice" class="button">Add new Service
				</button></a>
				
				<a href="addNewRoom.jsp"><button name="newroom" class="button">Add new Room
				</button></a>
				</div>			
				<div>
					<form action="Guest" method="POST">
					<button name="action" type="submit" value="View guest list"
						class="button">View guest list</button>
				</form>
				
				<form action="Report" method="POST">
					<button name="action" type="submit" value="View service list"
						class="button">View service list</button>
				</form>
				
				<form action="Report" method="POST">
					<button name="action" type="submit" value="View room list"
						class="button">View room list</button>
				</form>
				
				<a href="getPayments.jsp"><button name="viewpayments" class="button">View payments
				</button></a>
				</div>
				
				
				<c:if test="${title eq checkval1}">
				<hr/>
				<div class ="right">
					<form action="User" method="POST">
					<button name="action" type="submit" value="View users"
						class="button">View users</button>
				</form>
				<a href="removeuser.jsp"><button name="removeuser" class="button">Remove User
				</button></a>
				</div>
				<div>
					<a href="adduser.jsp"><button name="adduser" class="button">Add User
				</button></a>
				
				<a href="roomrate.jsp"><button name="rrate" class="button">Set room rate
				</button></a>
				</div>
			
				<br />
				<br />
			</c:if>
			
			</c:when>
			</c:choose>
		</fieldset>
		<br />
	</div>
</body>
</html>