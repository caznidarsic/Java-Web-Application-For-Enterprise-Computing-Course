<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="znidarsic_c_hw7.InputValidation"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Student Registration Site</title>

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
	<h1>Student Registration Site</h1>
	<h2>Wrong UserID and/or Password</h2>
	<h2>Please try to login again or to register</h2>
    <form action="RegistrationController" method="POST">
    	<input type="hidden" name="formname" value="loginfailure">
    	<table>
    	
    	<tr>
        	<td><input type="radio" name="failradio" value="Login"> Login<td/>
        <tr />
        
        <tr>
        	<td><input type="radio" name="failradio" value="Register"> Register<td/>
        <tr />
        
        <tr>
        	<td><input type="submit" value="Submit"><td/>
        <tr />
        
    	</table>
    </form>
    </div>
</body>
</html>