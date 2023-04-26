<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.portal.RentalApp.pojo.Posting" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Posting</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">
		<div style="padding:20px; background-color: #e6e6e6;"><h2>View post - ${requestScope.posting.name}	</h2></div></br>

		<% if(((Posting)request.getAttribute("posting")).isAvailable() == false) {%> 
			<div style="padding:20px; background-color: #f6a7a7;"><h3>This property is no longer available</h3></div></br>
		<% } else {%>
			<div style="padding:20px; background-color: #f6a7a7;"><h3>This property is available</h3></div></br>
		<%}%>
		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			
				</br></br>
			${requestScope.posting.address}		</br></br>
			${requestScope.posting.pincode}		</br></br>
			${requestScope.posting.cost}		</br></br>
		</div>

		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			<h3>Send an enquiry </h3>

			<form action="enquiry" method="post">
				<input type="hidden" name="postingid" value="${requestScope.posting.postid}"> 
				Name : <br />
				<input type="text" name="name" required/> <br /><br />

				Mobile No:<br />
				<input type="number" name="phoneNo" required> <br /><br />

				Email ID:<br />
				<input type="text" name="email" required> <br /><br />

				Additional enquiry/comment:<br />
				<textarea id="comment" name="comment" rows="4" cols="100" required></textarea>
				
				<br /> <br /> <input type="submit" value="Submit enquiry"/>		
			</form>	
		</div>
	</div>


</body>
</html>
