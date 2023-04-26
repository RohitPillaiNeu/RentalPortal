<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.portal.RentalApp.pojo.Ticket" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Tickets</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">
		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>Customer Tickets</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>

<!-- 		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;"> -->
<%-- 			<h3>Total open tickets : ${request.openCount}</h3></br> --%>
<%-- 			<h3>Severe tickets : ${request.urgentCount}</h3></br> --%>
<%-- 			<h3>High priority tickets : ${request.highCount}</h3></br> --%>
<%-- 			<h3>Normal priority tickets : ${request.normalCount}</h3></br> --%>
<%-- 			<h3>Closed priority : ${request.openCount}</h3> --%>
<!-- 		</div> -->

		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			<h3>Open Tickets: </h3>
			</br>
			<% 
				List<Ticket> openticketList = (List<Ticket>) request.getAttribute("openTickets");
				for (Ticket ticket : openticketList) {
			%>
				<a href="viewticket?key=<%=ticket.getTicketid()%>"><%=ticket.getTitle()%></a></br>
				<div style="display: inline-block; float: right; margin-right: 100px;">
					Priotiy: <%=ticket.getPriority()%> 
					&nbsp;
					Created: <%=ticket.getCreateDate()%>
				</div>
				</br>
			<%
			}
				if(openticketList.size() == 0) {
			%> 	
				<div style="text-align: center; padding:10px">No open tickets</div>
			<%}%> 	
		</div>


		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			<h3>Closed Tickets: </h3>
			</br>
			<% 
				List<Ticket> closedTickets = (List<Ticket>) request.getAttribute("closedTickets");
				for (Ticket ticket : closedTickets) {
			%>
				<a href="viewticket?key=<%=ticket.getTicketid()%>"><%=ticket.getTitle()%></a></br>
				<div style="display: inline-block; float: right; margin-right: 100px;">
					Priotiy: <%=ticket.getPriority()%> 
					&nbsp;
					Created: <%=ticket.getCreateDate()%>
				</div>
				</br>
			<%
			}
				if(openticketList.size() == 0) {
			%> 	
				<div style="text-align: center; padding:10px">No open tickets</div>
			<%}%> 	
		</div>
	</div>
</body>
</html>
