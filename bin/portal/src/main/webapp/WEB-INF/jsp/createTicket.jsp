<!-- login-view page -->

<%-- ${user.userId} --%>
<%-- ${user.name} --%>
<%-- ${user.userName} --%>
<%-- ${user} --%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Ticket</title>
</head>
<body>

	Create a new ticket
	<form action="ticketCreate" method="post">
			Topic : <input type="text" name="title" required/> <br />
			Description of the issue:<input type="text" name="description" required> <br />
			
			<label for="priority">Priority:</label>
			<input type="radio" id="priority-normal" name="priority" value="3" checked>
			<label for="priority-normal">Normal</label>
			<input type="radio" id="priority-high" name="priority" value="2">
			<label for="priority-high">High</label>
			<input type="radio" id="priority-urgent" name="priority" value="1">
			<label for="priority-urgent">Urgent/Critical</label>
			
			<br /> <br /> <input type="submit" value="Open ticket"/>		
	</form>	
	
</body>
</html>
