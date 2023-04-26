<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.portal.RentalApp.pojo.Posting" %>
<%@ page import="com.portal.RentalApp.pojo.Enquiry" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Posting</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">
		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>View post - ${requestScope.posting.name}	</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>

		<% if(((Posting)request.getAttribute("posting")).isAvailable() == false) {%> 
			<div style="padding:20px; background-color: #f6a7a7;"><h3>This property is no longer available</h3></div></br>
		<% } %>
		
		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<a href="togglepost?key=${requestScope.posting.postid}&toggle=true">Toggle availability</a></br>
			<a href="editpost?action=edit&postid=${requestScope.posting.postid}">Edit post</a></br>
			<a href="deletepost?key=${requestScope.posting.postid}&delete=true">Remove post</a></br>
			<a href="exportenquiry?key=${requestScope.posting.postid}">Export all enquiries</a></br>		
		</div></br>

		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			
				</br></br>
			${requestScope.posting.address}		</br></br>
			${requestScope.posting.pincode}		</br></br>
			${requestScope.posting.cost}		</br></br>
		</div>

		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			<h3>User enquiries: </h3>

			<!-- Enquiries -->
			<% 
				List<Enquiry> enquiryList = (List<Enquiry>) request.getAttribute("enquiries");
				for (Enquiry enquiry : enquiryList) {
			%>
			<div>
			<span><%= enquiry.getName() %></span> &nbsp
				<span><%= enquiry.getPhoneNo() %></span> &nbsp
				<span><%= enquiry.getEmail() %></span> </br>
				<span><%= enquiry.getComment() %></span>
				</div>
				</br> </br>
			<% } if(enquiryList.size() == 0) {
			%> 	
				<div style="text-align: center; padding:10px">No enquiries</div>
			<%}%> 
		</div>
	</div>
</body>
</html>
