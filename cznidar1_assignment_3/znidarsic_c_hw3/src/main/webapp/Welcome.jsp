<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="znidarsic_c_hw3.UserBean"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Registration Form B</title>

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
	<h1>
	<%
		UserBean userBean = (UserBean)request.getAttribute("gurubean");
		out.print("Welcome, " + userBean.getUserid());
	%>
	</h1>
    </div>
</body>
</html>