<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Register</title>
</head>

<body>
<h1>Update User Info</h1>

    <form:form action="update" method="POST" modelAttribute="userform">
    	<table>
    	<tr>
        	<td>UserID: ${userform.userId }<td/>
        	<%-- <td><form:input path="userId" type="text" placeholder="Enter UserID"></form:input><form:errors path="userId"></form:errors><td/> --%>
        	<td><form:input path="userId" type="hidden" value="${userform.userId }"></form:input><form:errors path="userId"></form:errors><td/>
        <tr />
        
        <tr>
        	<td>First Name: ${userform.firstName }<td/>
        	<%-- <td><form:input path="firstName" type="text" placeholder="Enter First Name"></form:input><form:errors path="firstName"></form:errors><td/> --%>
        	<td><form:input path="firstName" type="hidden" value="${userform.firstName }"></form:input><form:errors path="firstName"></form:errors><td/>
        <tr />
        
        <tr>
        	<td>Last Name: ${userform.lastName }<td/>
        	<%-- <td><form:input path="lastName" type="text" placeholder="Enter Last Name"></form:input><form:errors path="lastName"></form:errors><td/> --%>
        	<td><form:input path="lastName" type="hidden" value="${userform.lastName }"></form:input><form:errors path="lastName"></form:errors><td/>
        <tr />
        
        <tr>
        	<td>Date of Birth: <td/>
        	<td><form:input path="dateOfBirth" type="date" placeholder="Enter Date of Birth" value="${userform.dateOfBirth }"></form:input><form:errors path="dateOfBirth"></form:errors><td/>
        <tr />
        

        <tr>
        	<td>Street: <td/>
        	<td><form:input path="street" type="text" placeholder="Enter Street"></form:input><form:errors path="street"></form:errors><td/>
        <tr />

        
        <tr>
        	<td>City, State:<td/>
        	<td><form:input path="city" type="text" placeholder="Enter city"></form:input><form:errors path="city"></form:errors>,
        	<form:input path="state" type="text" maxlength="2" size="2"></form:input><form:errors path="state"></form:errors>
<%--   			<form:select path="state" name="state" value="${userform.state }">
				<option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AR">AR</option>
				<option value="AZ">AZ</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DC">DC</option>
				<option value="DE">DE</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="IA">IA</option>
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="MA">MA</option>
				<option value="MD">MD</option>
				<option value="ME">ME</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MO">MO</option>
				<option value="MS">MS</option>
				<option value="MT">MT</option>
				<option value="NC">NC</option>
				<option value="NE">NE</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>
				<option value="NV">NV</option>
				<option value="NY">NY</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VT">VT</option>
				<option value="VA">VA</option>
				<option value="WA">WA</option>
				<option value="WI">WI</option>
				<option value="WV">WV</option>
				<option value="WY">WY</option>
			</form:select><form:errors path="state"></form:errors> --%>
  			<td/>
  			
        <tr />
        
        <tr>
        	<td>ZIP/Postal Code: <td/>
        	<td><form:input path="zip" type="text" placeholder="Enter Zipcode"></form:input><form:errors path="zip"></form:errors><td/>
        <tr />
        
        <tr>
        	<td><input type="submit" value="Update"><td/>
        <tr />
        
    	</table>
    </form:form>
    
    
       
    
<br>
</body>
</html>