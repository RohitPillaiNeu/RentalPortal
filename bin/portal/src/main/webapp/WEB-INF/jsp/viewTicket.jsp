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
<%@ page import="com.portal.RentalApp.pojo.TicketConversation" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Tickets</title>
</head>
<body>

	View Tickets
	
	</br> ${requestScope.ticket.title}
	</br> ${requestScope.ticket.description}
	</br> ${requestScope.ticket.priority}
	</br> ${requestScope.ticket.createDate}
	
	
    <a href="ticketreopen?key=${requestScope.ticket.ticketid}">Reopen ticket</a></br>
    <a href="ticketresolve?key=${requestScope.ticket.ticketid}">Mark ticket resolved</a></br></br>
    
    comments
    
	<% 
  		List<TicketConversation> commentList = (List<TicketConversation>) request.getAttribute("conversations");
	%>
	<%
  	for (TicketConversation comment : commentList) {
	%>
		<%=comment.getSender().getUserName()%> (<%=comment.getDate()%> <%=comment.getTime()%>) :
		</br>
		 <%=comment.getMessage()%>
		</br></br>
	<%
  		}
	%>

	<form action="ticketcomment" method="post">	
			<input type="hidden" name="ticketid" value="${requestScope.ticket.ticketid}"> <br />
			Add comment : <input type="text" name="comment" required/> <br />
			<br /> <br /> <input type="submit" value="Submit comment"/>		
	</form>	
</body>
</html>
