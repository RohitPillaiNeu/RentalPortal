<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Property Portal</title>
</head>
<body>

		<form action="login" method="post">
			Username : <input type="text" name="userName" value="${requestScope.userid}" required/> <br />
			Password:<input type="password" name="userPassword" required>
			
			<br /> <br /> <input type="submit" />
			
			<br />
			${requestScope.error}
			<c:if test="${requestScope.error}">
         		Invalid UserID and Password
      		</c:if>
		</form>
</body>
</html>
