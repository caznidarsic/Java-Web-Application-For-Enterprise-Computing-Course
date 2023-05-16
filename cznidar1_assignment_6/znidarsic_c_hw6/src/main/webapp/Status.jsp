<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%@page import="znidarsic_c_hw6.InputValidation"%>
 --%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Registration Status Report</title>

<style type="text/css">
.container{
	border: 10px solid gray;
	max-width: 700px;
	margin: auto;
	background: rgba(255, 90, 90, .7);
	}
table, th, td {
  border: 1px solid black;
}
</style>

</head>


<body>
	<div class="container">
	<h1>Registration Status Report</h1>
	<br>
	<h2> Check any specific course(s) and click on Submit.</h2>
    <form action="RegistrationController" method="POST">
    	<input type="hidden" name="formname" value="statusForm">
    	<table>
	    	<%
		    	ArrayList<String[]> options = new ArrayList<String[]>();
	    		options = (ArrayList<String[]>)request.getAttribute("courses");
	    		for (String[] option : options) {
	    			out.print(
	    			"<tr>" +
		    				"<td>" +
		    					"<input type=\"checkbox\" id=\"option\" name=\"inputs\" value=\"" + option[0] + "\"><label for=\"option\">" + option[0] + " " + option[1] + "</label>" +
							"</td>" +
	    			"</tr>");
	    		}
		    	
	    	%>
	    </table>
		
		<table>
		        <%
		        	if (request.getAttribute("ejbCourseData") != null) {
 		        		out.print(
		        		"<tr> " +
							"<td>Course Id</td> " +
							"<td>Course Name</td> " +
							"<td>Students Enrolled</td> " +
						"</tr>");
		        		ArrayList<String[]> ejbCourseData = (ArrayList<String[]>)request.getAttribute("ejbCourseData");
		        		for (String[] result_0 : ejbCourseData) {
		        			out.print("<tr>");
		        			for (String result_1 : result_0) {
		        				out.print("<td>");
		        				out.print(result_1 + " ");
		        				out.print("</td>");
		        			}
		        			out.print("</tr>");
		        		}
		        		out.print("<br>");
		        	}
		        
		        %>
        
    	</table>
		<br>
		<input type="submit" name="selection" value="Back">
		<input type="submit" name = "selection" value="Submit">
    	
    	<input type="hidden" name="numberOfOptions" value="5">
    </form>
    </div>
</body>
</html>