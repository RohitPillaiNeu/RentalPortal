<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Add User Form</title>
</head>
<body>

<h2>Register a New User</h2>

<form:form modelAttribute="user" method="post">

<table>
<tr>
    <td>First Name:</td>
    <td><form:input path="first" size="30" /> <font color="red"><form:errors path="first"/></font></td>
</tr>

<tr>
    <td>Last Name:</td>
    <td><form:input path="last" size="30" /> <font color="red"><form:errors path="last"/></font></td>
</tr>

<tr>
    <td colspan="2"><input type="submit" value="Create User" /></td>
</tr>
</table>

</form:form>

</body>
</html>