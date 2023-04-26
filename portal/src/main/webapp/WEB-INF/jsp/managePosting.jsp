<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.portal.RentalApp.pojo.Posting" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Posting</title>
</head>
<body>

	<div style="padding:30px 60px; font-family: verdana;">
		<div style="padding:20px; background-color: #e6e6e6;">
			<h2>Manage postings</h2>
			<div style="display: inline-block; float: right;"><a href="logout">Logout</a></div>
		</div></br>

		<div style="padding:20px; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<a href="editpost?action=create">Create a new posting</a> </br>
		</div></br>

		<div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #e6e6e6;">
			<h3>All created postings: </h3>
			</br>
			<% 
		  		List<Posting> postList = (List<Posting>) request.getAttribute("postings");
		  		for (Posting post : postList) {
			%>
				<a href="viewpost?key=<%=post.getPostid()%>"><%=post.getName()%></a></br>
				<% if(post.isAvailable()) { %>
				<div style="display: inline-block; float: right; margin-right: 100px;">Available</div>
				<% } else { %>
				<div style="display: inline-block; float: right; margin-right: 100px;">Unavailable</div>
				<% } %>
				</br>
			<% } 
		  		if(postList.size() == 0) {
			%> 	
				<div style="text-align: center; padding:10px">No posts yet</div>
			<%}%> 	
		</div>
	</div>

	
</body>
</html>
