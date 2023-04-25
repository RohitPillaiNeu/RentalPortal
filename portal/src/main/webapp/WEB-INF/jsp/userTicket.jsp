<!-- login-view page -->

<%-- ${user.userId} --%>
<%-- ${user.name} --%>
<%-- ${user.userName} --%>
<%-- ${user} --%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.portal.RentalApp.pojo.Ticket" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Tickets</title>
</head>
<body>

	User Tickets
		
	<a href="ticketCreate">Create a new ticket</a> </br>
	
	Your open tickets
	<% 
  		List<Ticket> openticketList = (List<Ticket>) request.getAttribute("openTickets");
	%>

<%
  for (Ticket ticket : openticketList) {
%>
    <a href="viewticket?key=<%=ticket.getTicketid()%>"><%=ticket.getTitle()%></a></br>
<%
  }
%>
	
	Previous resolved tickets
		<% 
  		List<Ticket> closedTicketList = (List<Ticket>) request.getAttribute("closedTickets");
	%>

<%
  for (Ticket ticket : closedTicketList) {
%>
    <a href="viewticket?key=<%=ticket.getTicketid()%>"><%=ticket.getTitle()%></a></br>
<%
  }
%>
	
</body>
</html>
