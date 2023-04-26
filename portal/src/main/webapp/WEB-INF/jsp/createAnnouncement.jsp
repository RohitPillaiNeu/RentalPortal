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
<title>Create Announcement</title>
</head>
<body>

	<form action="announcement" method="post" enctype="multipart/form-data">
			
			Title : <input type="text" name="title" required/> <br />
			Body:<input type="text" name="body" required> <br />
			<br />
			<br />
			
			Upload an image (optional):
			<input type="file" name="image">
			<br /> <br /> <button type="submit" >Create</button>	
	</form>		
	
</body>
</html>
