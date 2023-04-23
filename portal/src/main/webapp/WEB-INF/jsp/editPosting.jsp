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
<title>Create Edit Posting</title>
</head>
<body>
	<form action="editpost" method="post" enctype="multipart/form-data">
			Listing Title : <input type="text" name="name" value="${requestScope.name}" required/> <br />
			Description:<input type="text" name="description" value="${requestScope.description}" required> <br />
			Address:<input type="text" name="address" value="${requestScope.address}" required> <br />
			Pin-code:<input type="text" name="pincode" value="${requestScope.pincode}" > <br />
			Cost:<input type="number" name="cost" value="${requestScope.cost}"> <br />
			
			
			Apartment available? 
<!-- 			<c:choose> -->
<%--    				<c:when test="${requestScope.isAvailable}"> --%>
<!-- 					<input type="checkbox" name="isAvailable" value="true" checked> -->
<!--    				</c:when> -->
<!-- 	    		<c:otherwise> -->
<!-- 					<input type="checkbox" name="isAvailable" value="true"> -->
<!--     			</c:otherwise> -->
<!-- 			</c:choose> -->
			<br />
			<br />
			
			
			Upload an image of the apartment
			<input type="file" name="image">
			<br /> <br /> <input type="submit" />		
	</form>		
</body>
</html>
