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
<%@ page import="com.portal.RentalApp.pojo.Posting" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Posting</title>
</head>
<body>

	${requestScope.userName}
	
	<a href="editpost?action=create">Create a new posting</a> </br>
	
<!-- 	List of postings -->
	<% 
  		List<Posting> postList = (List<Posting>) request.getAttribute("postings");
	%>

<%
  for (Posting post : postList) {
%>
    <a href="viewpost?key=<%=post.getPostid()%>"><%=post.getName()%></a></br>
<%
  }
%>
<!-- 	List of postings END -->

</body>
</html>
