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

	<div style="padding:30px 60px; font-family: verdana;">
			
		<div style="padding:20px; background-color: #fff1d8;">
			<h2>Welcome ${requestScope.userName}</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>
		
		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<a href="ticket">Create/manage Tickets</a> </br>
		</div></br>
		
		
		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			<h3>Announcements: </h3>
			</br>


			<% 
  				List<Announcement> announcements = (List<Announcement>) request.getAttribute("announcements");
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

				if(announcements.size() == 0) {
			%> 	
				<div style="text-align: center; padding:10px">No announcements yet</div>
			<%}%> 	
		</div>
	</div>
	
	
</body>
</html>
