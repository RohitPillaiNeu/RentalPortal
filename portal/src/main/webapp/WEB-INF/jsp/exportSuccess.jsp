<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Export started</title>
</head>
<body>
	<div style="padding:30px 60px; font-family: verdana;">
			
		<div style="padding:20px; background-color: #9bee88; text-align: center;"><h2>Exported all enquiries successfully!</h2></div></br>
		
		<div style="padding:20px; text-align: center; margin-bottom: 30px; background-color: #e6e6e6b0;">
			<a href="viewpost?key=${responseScope.key}">Go back</a>
		</div></br>
	</div>
</body>
</html>
