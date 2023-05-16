Christian Znidarsic
Final Assignment

Content:

	This project is a simple Java web application built using Spring MVC.
	
	It makes use of the Spring MVC Framework. It uses the Hibernate Validator API for perform data validation on data submitted via forms. It does not use any persistence or data storage so data is all static and meant for demonstration purposes.

How to Deploy This Project:

	Method 1: 
		1. Run the project in Eclipse. Make sure WildFly server is set up in Eclipse.

	Method 2:
		1. Export the project as a WAR file from Eclipse
		2. Save the WAR file to Wildfly_Home/standalone/deployments
		3. If the server is not already running, start it by running bin/standalone.sh
		4. In your browser, go to localhost:9990 to view the server
		5. Select "Deployments" to view active web applications


Courses at full capacity:
	Intro to Advanced Studies
	Intro to Advanced Studies of Advanced Studies

Courses with capacity:
	Intro to Studies
	Advanced Studies

Most challenging steps:
	The most challenging aspect of this project was the initial setup, which includes all the configuration steps in spring-servlet.xml and web.xml. Just getting the application to work the first time took the most effort. Other difficult aspects were getting the form validation to work. In particular, validating the date and state values were somewhat difficult. I can tell that with more experience though, Spring MVC can be much simpler to use that Java EE.