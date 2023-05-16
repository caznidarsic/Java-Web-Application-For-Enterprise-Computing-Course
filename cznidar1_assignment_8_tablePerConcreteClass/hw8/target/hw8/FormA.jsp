<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="znidarsic_c.InputValidation"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Registration Form A</title>

<style type="text/css">
.container{
	border: 10px solid gray;
	max-width: 700px;
	margin: auto;
	background: rgba(255, 90, 90, .7);
	}
</style>

</head>


<body>
	<div class="container">
	<h1>Registration Form A</h1>
    <form action="RegistrationController" method="POST">
    	<input type="hidden" name="formname" value="formA">
    	<table>
    	
    	
    	<tr>
        	<td>User Id: <td/>
        	<td><input type="text" name="userid" required><td/>
        <tr />
        
        <tr>
        	<td>Password: <td/>
        	<td><input type="password" name="password" maxlength="20" required><td/>
        <tr />
        
        <tr>
        	<td>Password (repeat): <td/>
        	<td><input type="password" name="passwordrepeat" maxlength="20" required><td/>
        <tr />
        
        <tr>
        	<td>First Name: <td/>
        	<td><input type="text" name="firstname" maxlength="20" required><td/>
        <tr />
        
        <tr>
        	<td>Last Name: <td/>
        	<td><input type="text" name="lastname" maxlength="20" required><td/>
        <tr />
        
        <tr>
        	<td>Social Security Number:<td/>
        	<td><input type="text" name="ssn1" maxlength="3" size="3" required> -
  			<input type="text" name="ssn2" maxlength="2" size="2" required> -
  			<input type="text" name="ssn3" maxlength="4" size="4" required><td/>
        <tr />
        
        <tr>
        	<td>Email: <td/>
        	<td><input type="email" name="email" maxlength="255" required><td/>
        <tr />
        
        <tr>
        	<td><input type="submit" value="Continue"><td/>
        <tr />
        
        
    	</table>
    </form>
    </div>
</body>
</html>