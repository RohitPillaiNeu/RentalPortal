<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin home</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">
			
		<div style="padding:20px; background-color: #ffd791;">
			<h2>Admin view - Welcome ${requestScope.userName}</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>

		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<a href="post">Manage property postings</a> </br> </br>
			<a href="announcement">Send message/announcements</a> </br> </br>
			<a href="ticket">User Tickets</a> </br>
		</div></br>
	</div>
	
	
	
</body>
</html>
