<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Edit Posting</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>	
	<div style="padding:30px 60px; font-family: verdana;">
			
		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>Create a new posting</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>
		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; border: 2px solid rgb(146, 146, 146);">

			<form action="editpost?action=create&postid=${requestScope.postid}" method="post" enctype="multipart/form-data">
				Listing Title : <br />
				<input type="text" name="name" value="${requestScope.name}" required/> 
				<br /><br />
				
				Description: <br />
				<textarea id="message" name="description" value="${requestScope.description}" rows="10" cols="100" required></textarea><br /><br />

				Address:<br />
				<input type="text" name="address" value="${requestScope.address}" required> <br />

				Pin-code:<br /><input type="text" name="pincode" value="${requestScope.pincode}" > <br />

				Cost:<br /><input type="number" name="cost" value="${requestScope.cost}"> <br /><br />
				
				
				Is Apartment available? 
				
				<% 
					  if(request.getAttribute("isAvailable") == null || (boolean)request.getAttribute("isAvailable") == true)	{
				%>
				<label for="priority">Yes</label><input type="radio" id="priority-normal" name="priority" value="true" checked>
				<label for="priority-normal">No</label><input type="radio" id="priority-high" name="priority" value="false">
				<% 
					  } else {
				%>
				<label for="priority">Yes</label><input type="radio" id="priority-normal" name="priority" value="true">
				<label for="priority-normal">No</label><input type="radio" id="priority-high" name="priority" value="false" checked>
				<% 
					  }
				%>
				<br />
				<br />
				
				<div style="display:none;">
					Upload an image of the apartment
					<input type="file" name="image">
				</div>
				<br /> <br /> <input type="submit" value="Publish posting"/>		
			</form>	

		</div>
	</div>
</body>
</html>
