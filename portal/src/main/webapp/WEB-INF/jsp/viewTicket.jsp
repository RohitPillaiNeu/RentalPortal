<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.portal.RentalApp.pojo.Ticket" %>
<%@ page import="com.portal.RentalApp.pojo.TicketConversation" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Tickets</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">

		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>View Tickets</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>

		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<% if(((Ticket) request.getAttribute("ticket")).isResolved()) { %>
				<h3>This ticket is closed.</h3>
				<a href="ticketreopen?key=${requestScope.ticket.ticketid}">Reopen ticket</a>
			<% } else {	 %>
				<h3>This ticket is open.</h3>
				<a href="ticketresolve?key=${requestScope.ticket.ticketid}">Close ticket</a>
			<% } %>
		</div></br>

		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<h4>${requestScope.ticket.title}</h4>
			<h5>Priority: ${requestScope.priority}</h5>
			<h5>${requestScope.ticket.description}</h5>
			<h6>Created on :${requestScope.ticket.createDate}</h6> 
		</div></br>

		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<h4>Comments:</h4>
			<div style="padding:20px 0px; margin-bottom: 30px; border: 1px solid rgb(140, 140, 140);"">
				<% 
  					List<TicketConversation> commentList = (List<TicketConversation>) request.getAttribute("conversations");
  					for (TicketConversation comment : commentList) {
				%>
					<h4><%=comment.getSender().getUserName()%> (<%=comment.getDate()%> <%=comment.getTime()%>) :</h4>
					 <%=comment.getMessage()%>
					</br>
				<%}%>
			</div>
			<form action="ticketcomment" method="post">	
					<input type="hidden" name="ticketid" value="${requestScope.ticket.ticketid}"> <br />
					<textarea id="comment" name="comment" rows="4" cols="100" required></textarea>
					<br /> <br /> <input type="submit" value="Submit comment"/>		
			</form>	
		</div>
	</div>
</body>
</html>
