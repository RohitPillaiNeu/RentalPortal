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

${requestScope.posting}				</br>

${requestScope.posting.name}		</br>

${requestScope.posting.description}	</br>

${requestScope.posting.address}		</br>

${requestScope.posting.pincode}		</br>

${requestScope.posting.cost}		</br>

Availability: ${requestScope.posting.isAvailable()}	</br>
&nbsp 



<form action="enquiry" method="post">
			<input type="hidden" name="postingid" value="${requestScope.posting.postid}"> <br />
			Name : <input type="text" name="name" required/> <br />
			Mobile No:<input type="number" name="phoneNo" required> <br />
			Email ID:<input type="text" name="email" required> <br />
			Additional enquiry/comment<input type="text" name="comment" > <br />
			
			<br /> <br /> <input type="submit" />		
</form>	


<!-- User forms -->


</body>
</html>
