<!-- login-view page -->

<%-- ${user.userId} --%>
<%-- ${user.name} --%>
<%-- ${user.userName} --%>
<%-- ${user} --%>


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

	Total open tickets - 6
	Servere tickets - 2
	High priority tickets - 3
	Normal priority tickets - 1
	
	</br>
	Open Tickets
		
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

	</br>
	</br>
	Open Tickets
		
	<% 
  		List<Ticket> closedTickets = (List<Ticket>) request.getAttribute("closedTickets");
	%>
<%
  for (Ticket ticket : closedTickets) {
%>
    <a href="viewticket?key=<%=ticket.getTicketid()%>"><%=ticket.getTitle()%></a></br>
<%
  }
%>
</body>
</html>
