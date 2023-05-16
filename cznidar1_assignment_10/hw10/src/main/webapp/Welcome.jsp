<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="znidarsic_c.UserBean"%>
    <%@page import="znidarsic_c.Person"%>
    <%@page import="znidarsic_c.Student"%>
    <%@page import="znidarsic_c.PersistenceUtility"%>
    <jsp:useBean id="con" class="znidarsic_c.DBConnection"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Welcome</title>

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
		<h2>Welcome to the site, 
		<%
			
			Student student = PersistenceUtility.getStudent((String)session.getAttribute("userid"));
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			
			if (firstName != null && lastName != null) {
				out.print(firstName + " " + lastName);
			}
			else {
				System.out.println("FIRSTNAME OR LASTNAME RETRIEVAL ERROR");
			}
			
		%>
		<br>
		Select your next action:
		</h2>
		
		<form action="RegistrationController" method="POST">
	    	<input type="hidden" name="formname" value="welcome">
	    	<table>
	    	
	    	<tr>
	        	<td><input type="radio" name="welcomeradio" value="register"> Register to the course<td/>
	        <tr />
	        
	        <tr>
	        	<td><input type="radio" name="welcomeradio" value="checkRegistration"> Check registration<td/>
	        <tr />
	        
	        <tr>
	        	<td><input type="radio" name="welcomeradio" value="status"> Get Status Report<td/>
	        <tr />
	        
	        <tr>
	        	<td><input type="radio" name="welcomeradio" value="logout"> Logout<td/>
	        <tr />
	        
	        <tr>
	        	<td><input type="submit" value="Submit"><td/>
	        <tr />
	        
	    	</table>
    	</form>
	
    </div>
</body>
</html>