<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Announcement</title>
</head>
<body>
	<div style="padding:30px 60px; font-family: verdana;">
			
		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>Create an Announcement</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>
		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; border: 2px solid rgb(146, 146, 146);">

			<form action="editpost?action=create&postid=${requestScope.postid}" method="post" enctype="multipart/form-data">
				Announcement Title : <br />
				<input type="text" name="title" required/> 
				<br /><br />

				Body: <br />
				<textarea id="body" name="body" rows="10" cols="100" required></textarea>
				<br />
				<br />
				
				<br /> <br /> <button type="submit" class="btn btn-primary">Send Announcement</button>		
			</form>	

		</div>
	</div>
	
</body>
</html>
