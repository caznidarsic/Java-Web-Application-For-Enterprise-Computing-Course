<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success!</title>
</head>
<body>
<h1>Your information has been successfully updated:</h1>
	<table>
		<tr><td>UserID:</td> <td>${userform.userId}</td></tr>
		<tr><td>First Name:</td> <td>${userform.firstName}</td></tr>
		<tr><td>Last Name:</td> <td>${userform.lastName}</td></tr>
		<tr><td>Date of Birth:</td> <td>${userform.dateOfBirth}</td></tr>
		<tr><td>Street:</td> <td>${userform.street}</td></tr>
		<tr><td>City:</td> <td>${userform.city}</td></tr>
		<tr><td>State:</td> <td>${userform.state}</td></tr>
		<tr><td>Zipcode:</td> <td>${userform.zip}</td></tr>
	</table>
	<form:form action="welcome" method="GET">
		<td><input type="submit" value="Back to Welcome"><td/>
	</form:form>
</body>
</html>