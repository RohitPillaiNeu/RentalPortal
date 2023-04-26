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
<%@ page import="com.portal.RentalApp.pojo.Announcement" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User home</title>
</head>
<body>

	user view - Welcome ${requestScope.userName}
	
	<a href="announcement">Message/announcements</a> </br>
	<a href="ticket">Create/manage Tickets</a> </br>
	
	Announcements: 
	<% 
  		List<Announcement> announcements = (List<Announcement>) request.getAttribute("announcements");
	%>
	<%
  	for (Announcement announcement : announcements) {
	%>
		<div>
			<h2><%=announcement.getName()%></h2>
        	<p><%=announcement.getBody()%></p>
        	<img src="/images/<%=announcement.getImageName()%>" alt="<%=announcement.getName()%> image">
        	<p>Date posted: <%=announcement.getDateCreated()%></p>
    	</div>
	<%
  		}
	%> 	
</body>
</html>
