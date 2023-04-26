<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
		<div style="padding:30px 60px;">
			
			<div style="padding:20px; background-color: #e6e6e6;"><h2>Login to portal</h2></br></div></br>
			<form action="login" method="post">
				Username : 
				<br />
				<input type="text" name="userName" value="${requestScope.userid}" required/> 
				<br />
				Password:
				<br />
				<input type="password" name="userPassword" required>
			
				<br /> <br /> <input type="submit" />
			
				<br />
				<% if(request.getAttribute("error") != null && (boolean)request.getAttribute("error") == true) {%>
         			Invalid UserID and Password
				<% } %>
      		
      		
				${requestScope.error} </br>
				${requestScope.name} </br>
				${requestScope.username} </br>
				${requestScope.password} </br>
				${requestScope.admin} </br>
			
			</form>
		</div>
</body>
</html>
