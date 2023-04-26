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
<title>Property listings</title>
</head>
<body>

  <div style="padding:30px 60px; font-family: verdana;">
    <div style="padding:20px; background-color: #e6e6e6;"><h2>Our available listings</h2></div></br>

    <div style="padding:20px 20px 50px 20px; margin-bottom: 30px; background-color: #ffeeaa;">
        
	  <% 
  		List<Posting> postList = (List<Posting>) request.getAttribute("postings");
      for (Posting post : postList) {
    %>
        <div style="padding: 10px;background-color: #fef7f7;">
          <h3><%=post.getName()%> &nbsp; ($<%=post.getCost()%>)</h3> </br>
          <span>Address: <%=post.getAddress()%></span></br>
			    <span>Pincode: <%=post.getPincode()%></span></br>
          </br>
          <a href="viewListing?key=<%=post.getPostid()%>">View post</a></br>
        </div>
      </br>
    <% } %>
    </div>
  </div>

	
</body>
</html>
