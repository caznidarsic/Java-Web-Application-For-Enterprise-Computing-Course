<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Register</title>
</head>

<body>
<h1>Register for Courses</h1>
<br>

<form:form action="register" method="POST" modelAttribute="registrationForm">
	Choose a course:
		<select name="courseSelection" id="courses">
			<c:forEach items="${Courses.courses}" var="course" varStatus="tagStatus">
				<option value="${course.getNumber()}">${course.toString()}</option>
			</c:forEach>
		</select>
	<input type="submit" value="Submit"/>
</form:form>

<form:form action="welcome" method="GET" modelAttribute="back">
	<input type="submit" value="Back"/>
</form:form>

${message}

<br>
</body>
</html>