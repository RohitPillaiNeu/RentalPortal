<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Ticket</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">
			
		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>Create a new ticket</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>
		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; border: 2px solid rgb(146, 146, 146);">

			<form action="ticketCreate" method="post">
				Topic : <br />
				<input type="text" name="title" required/> 
				<br /><br />

				Description of the issue: <br />
				<textarea id="description" name="description" rows="10" cols="100" required></textarea> <br /><br />
				
				<label for="priority">Priority:</label> <br />
				<input type="radio" id="priority-normal" name="priority" value="3" checked>
				<label for="priority-normal">Normal</label>
				<input type="radio" id="priority-high" name="priority" value="2">
				<label for="priority-high">High</label>
				<input type="radio" id="priority-urgent" name="priority" value="1">
				<label for="priority-urgent">Urgent/Critical</label>
				
				<br /> <br /> <input type="submit" value="Create ticket"/>		
			</form>	

		</div>
	</div>
	
	
</body>
</html>
