Christian Znidarsic
Assignment 9

Content:

	This project is a Java dynamic web application that makes use of servlets, JSPs, JSFs, EJBs and JPA. 

	This version implements the "Check Student Registration" use-case. It makes use of different JPA query types, including Criteria API and JPQL queries. The "Check Student Registration" page can be navigated to from the "Welcome" screen after successfully logging in. This new page allows the user to search for all courses registered by a given last name. The last name is entered in a text field and the submit button calls a method in the backing bean called "CheckRegistrationSupportBean.java". This method then calls PersistenceUtility.java which now uses both Criteria API and JPQL queries to query the H2 database for registration information. 

	In order to support this new functionality, this version also implements student-based course information. The H2 database was refactored so that the Registrar table holds only User_ID and Course_ID attributes. Now every time a student registers for a course, an entry to Registrar is made. The course registration code was also updated to check if a student is already registered for a course before a new entry is made. If they are already registered, an appropriate message is shown to reflect this. 

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

(NOTE: THIS VERSION USES A DIFFERENT CONNECTION-URL THAT CALLS TO LOCALHOST. NOW THE DATABASE MUST BE STARTED UP IN "SERVER MODE". THIS ALLOWS MULTIPLE SIMULTANEOUS ACCESSES. IN THE CASE OF THIS APPLICATION, SERVER MODE ALLOWS ACCESSES TO THE DATABASE USING BOTH HIBERNATE AND JDBC IN THE SAME APPLICATION. TO START THE H2 DATABASE IN "SERVER MODE", RUN THE FOLLOWING COMMAND:

java -cp h2-1.4.197.jar org.h2.tools.Server -webAllowOthers -tcpAllowOthers


Other Datasource details:

data-source add --jndi-name=java:jboss/datasources/H2_784_JNDI 
--name=H2_784_DS 
--connection-url=jdbc:h2:tcp://localhost/~/784/H2_784_DB;                          
--driver-name=h2  


Database Credentials 
(these are hardcoded as con.getConnection("sa", ""))

	UserId: "sa"
	Password: ""


Existing UserId and Password:

	UserId: sampleuser
	Password: samplepassword
