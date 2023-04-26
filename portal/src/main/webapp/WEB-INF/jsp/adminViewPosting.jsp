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
<%@ page import="com.portal.RentalApp.pojo.Enquiry" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Posting</title>
</head>
<body>

<%-- 	user view - Welcome ${requestScope.userName} --%>
	
<!-- 	<a href="announcement">Message/announcements</a> </br> -->
<!-- 	<a href="tickets">Create/manage Tickets</a> </br> -->

<%-- <% if( ((Posting)request.getAttribute("posting")).isAvailable() == true ) %>> --%>
${requestScope.posting}				</br>

${requestScope.posting.name}		</br>

${requestScope.posting.description}	</br>

${requestScope.posting.address}		</br>

${requestScope.posting.pincode}		</br>

${requestScope.posting.cost}		</br>

Availability: ${requestScope.posting.isAvailable()}	</br>
&nbsp 
<a href="viewpost?key=${requestScope.posting.postid}&toggle=true">Toggle availability</a></br>
</br>
<a href="editpost?action=edit&postid=${requestScope.posting.postid}">Edit post</a></br>
<a href="viewpost?key=${requestScope.posting.postid}&delete=true">Remove post</a></br>
<a href="exportenquiry?key=${requestScope.posting.postid}">Export all enquiries</a></br></br>

<!-- Enquiries -->
<% 
  		List<Enquiry> enquiryList = (List<Enquiry>) request.getAttribute("enquiries");
	%>

<%
  for (Enquiry enquiry : enquiryList) {
%>
	<div>
		<span><%= enquiry.getName() %></span> &nbsp
		<span><%= enquiry.getPhoneNo() %></span> &nbsp
		<span><%= enquiry.getEmail() %></span> </br>
		<span><%= enquiry.getComment() %></span>
	</div>
	 </br> </br>
<%
  }
%>

</body>
</html>
