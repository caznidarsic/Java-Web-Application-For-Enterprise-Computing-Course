Christian Znidarsic
Assignment 11

Content:

	This project is a Java dynamic web application that makes use of servlets, JSPs, JSFs, EJBs and JPA. 

	This version implements the Java Transactions API (JTA). For the course registration use-case, the RegistrationSupportBean.java class now calls the RegistrarCourseBean.java bean instead of calling PersistenceUtility.java to perform course registration. The RegistrarCourseBean bean uses transaction management when writing the registration information to the REGISTRAR table in the H2 database.
	This submission also contains a separate application that performs the same course registration procedure, except it only contains index.html, a servlet, the same RegistrarEntity.java bean and a RegistrarCourseBean.java file. This RegistrarCourseBean file is also the same as in the main SRS application described above. The servlet makes multiple calls to the RegistrarCourseBean and intentionally exceeds the timeout of 2 seconds we set in the WildFly Server. The results are returned and displayed in the browser to show the results. 

How to Deploy This Project:

	Method 1: 
		1. Run the project in Eclipse. Make sure WildFly server is set up in Eclipse.

	Method 2:
		1. Export the project as a WAR file from Eclipse
		2. Save the WAR file to Wildfly_Home/standalone/deployments
		3. If the server is not already running, start it by running bin/standalone.sh
		4. In your browser, go to localhost:9990 to view the server
		5. Select "Deployments" to view active web applications

NOTE: For this submission, the WildFly server must be started using the standalone-full.xml config file, as opposed to the standalone.xml config file that was used before. The full config file includes support of Java Message Service (JMS). This can be done from the command line, or it can be configured in Eclipse by changing the launch configuration properties for WildFly to include "--server-config=standalone-full.xml".


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


JMS Credentials

Username: mquser
Password: mqpassword
