Christian Znidarsic
Assignment 5

Content:

	This project is a set of Forms that the user enters information into to set up an account in a Student Registration Service (SRS) application.
	This version implements Java Server Faces for the "Register for Courses" page. This page is written in a .xhtml file and is backed by a backing bean using Context/Dependency Injection (CDI).


How to Deploy This Project:

	Method 1: 
		1. Run the project in Eclipse. Make sure WildFly server is set up in Eclipse.

	Method 2:
		1. Export the project as a WAR file from Eclipse
		2. Save the WAR file to Wildfly_Home/standalone/deployments
		3. If the server is not already running, start it by running bin/standalone.sh
		4. In your browser, go to localhost:9990 to view the server
		5. Select "Deployments" to view active web applications


Datasource Used:

data-source add --jndi-name=java:jboss/datasources/H2_784_JNDI 
--name=H2_784_DS 
--connection-url=jdbc:h2:~/784/H2_784_DB;DB_CLOSE_DELAY=-1                           
--driver-name=h2  


Database Credentials 
(these are hardcoded as con.getConnection("sa", ""))

	UserId: "sa"
	Password: ""


Existing UserId and Password:

	UserId: sampleuser
	Password: samplepassword
