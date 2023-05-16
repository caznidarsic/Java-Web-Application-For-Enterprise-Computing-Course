<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="znidarsic_c_hw4.InputValidation"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Welcome to the Student Registration Site</title>

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
	<h1>Welcome to the Student Registration Site</h1>
	<h2>If you already have an account, please log in</h2>
    <form action="RegistrationController" method="POST">
    	<input type="hidden" name="formname" value="login">
    	<table>
    	
    	
    	<tr>
        	<td>User Id: <td/>
        	<td><input type="text" name="userid"><td/>
        <tr />
        
        <tr>
        	<td>Password: <td/>
        	<td><input type="password" name="password" maxlength="20"><td/>
        <tr />
        
        <tr>
        	<td><input type="submit" name="selection" value="Log In"><td/>
        	<td><input type="reset" value="Reset"><td/>
        <tr />
                
    	</table>
    	<h2>For new users, please register first</h2>
    	<input type="submit" name="selection" value="Register">
    	
    </form>
    </div>
</body>
</html>