<!-- login-view page -->

<%-- ${user.userId} --%>
<%-- ${user.name} --%>
<%-- ${user.userName} --%>
<%-- ${user} --%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

${request.posting.name}

${request.posting.description}

${request.posting.address}

${request.posting.pincode}

${request.posting.cost}

Availability: ${request.posting.isAvailable}	
&nbsp 
<a href="viewpost?key=${request.posting.postid}&toggle=true">Toggle availability</a></br>
</br>
<a href="viewpost?key=${request.posting.postid}&delete=true">Remove post</a></br></br>


<!-- User forms -->


</body>
</html>
