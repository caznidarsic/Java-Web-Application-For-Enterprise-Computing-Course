package znidarsic_c;
import java.io.Serializable;
//import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

//import javax.faces.bean.ManagedBean;
import javax.inject.Named;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import javax.naming.*;
import javax.jms.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@Named
@SessionScoped
public class RegistrationSupportBean implements Serializable{
	
//	static final long serialVersionUID = 123;
    private String courseTitle;
    private String userId;
    private String registrationMessage = "";
//    private static Map<String, Object> courseTitleValue;
//    static
//    {
//        courseTitleValue = new LinkedHashMap<String, Object>();
//        
//        courseTitleValue.put("605.784 Enterprise Computing with Java", "605.784 Enterprise Conputing with Java"); //label, value
//        courseTitleValue.put("605.785 Web Services", "605.785 Web Services");
//        courseTitleValue.put("605.786 Enterprise System Design and Implementation", "605.786 Enterprise System Design and Implementation");
//    }
    

    public String getcourseTitle() {
        return courseTitle;
    }
    public void setcourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    
    public String getRegistrationMessage() {
    	return registrationMessage;
    }
    public void setRegistrationMessage(String registrationMessage) {
    	this.registrationMessage = registrationMessage;
    }
    
    public String getUserId() {
    	return userId;
    }
    public void setUserId(String userId) {
    	this.userId = userId;
    }

//    public Map<String, Object> getcourseTitleValue()
//    {
//        return courseTitleValue;
//    }
    
    
    
    
    
    
    public String registerForCourse() {
//    	DBConnection dbc = new DBConnection();
    	String courseId = courseTitle.substring(0, 7);
    	CourseEntity course = PersistenceUtility.getCourse(courseId);
    	
    	int maxNum = course.getMaxRegistered();
    	int curNum = course.getNumRegistered();
    	
//    	String maxNum = dbc.getValue("COURSES", "COURSE_ID", courseId, "MAX_REGISTERED");
//    	String curNum = dbc.getValue("COURSES", "COURSE_ID", courseId, "NUMBER_REGISTERED");
    	
    	
    	try {
    		if (curNum >= maxNum) {
	    		this.setRegistrationMessage("Sorry, the registration to this course has been closed based on availability");
	    	}
    		else if (PersistenceUtility.alreadyRegistered((String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid"), courseId)) {
    			this.setRegistrationMessage("You are already registered for the course: " + course.getCourseId() + " " + course.getCourseTitle());

    		}
	    	else {
	    		int newVal = curNum + 1;
	    		
	    		course.setNumRegistered(newVal);
	    		PersistenceUtility.updateCourseRegistration(courseId, newVal);
	    		
	    		String userId = (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid");
	    		
	    		RegistrarEntity regEntity = new RegistrarEntity();
	    		regEntity.setCourseId(courseId);
	    		regEntity.setUserId(userId);
	    		PersistenceUtility.persistRegistrarEntity(regEntity);

	    		this.setRegistrationMessage("You are now registered for " + courseTitle + ".");
	    		

	    		
	    		
	    		
	    		String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    		    String DEFAULT_DESTINATION = "jms/topic/RegCourseTopic";
    		    String DEFAULT_USERNAME = "mquser";
    		    String DEFAULT_PASSWORD = "mqpassword";
    		    String INITIAL_CONTEXT_FACTORY = "org.wildfly.naming.client.WildFlyInitialContextFactory";
    		    String PROVIDER_URL = "http-remoting://127.0.0.1:8080";



		        Context namingContext = null;
		        Connection conn = null;
		        ConnectionFactory connectionFactory = null;
		        Session session = null;    

		      try {
		            String userName = System.getProperty("username", DEFAULT_USERNAME);
		            String password = System.getProperty("password", DEFAULT_PASSWORD);

		            // Set up the namingContext for the JNDI lookup
		            final Properties env = new Properties();
		            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
		            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
		            env.put(Context.SECURITY_PRINCIPAL, userName);
		            env.put(Context.SECURITY_CREDENTIALS, password);
		            namingContext = new InitialContext(env);

		            // Perform the JNDI lookups
		            String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
		            connectionFactory = (ConnectionFactory) namingContext.lookup(connectionFactoryString);

		        } catch (NamingException e) {
		             e.printStackTrace();   
		        }  

		        try {

		            conn = connectionFactory.createConnection("mquser", "mqpassword");
		            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		        
		            Queue queue = session.createQueue("testQueue");
		            Topic topic = session.createTopic(DEFAULT_CONNECTION_FACTORY);
		 
		            
		            MessageProducer producer = session.createProducer(topic);
		            
		            conn.start();       
		            
		            
		            
		            
		            MapMessage mapMessage = session.createMapMessage();
		            mapMessage.setString("User_ID", (String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userid"));
		            mapMessage.setString("Course_ID", courseId);
		            mapMessage.setString("Course_Name", course.getCourseTitle());
		            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		            mapMessage.setString("Date_of_Registration", formatter.format(new Date()));
		            
		            
		            
		            
		            producer.send(mapMessage);


		        }  catch (JMSException e) {
		             e.printStackTrace();
		             
		        }   finally {
		                System.out.println("END!!!");
		            
		            } 
	    		
	    		
	    		
	            
	    	}
    	}
    	catch (NumberFormatException e) {
    		e.printStackTrace();
    	}
    	
//    	System.out.println("You have registered!");
    	return "Registration";
    }
    
    
    
    
    
    
    
    public static class Course
    {
        public String courseLabel;
        public String courseValue;
        
        public Course(String courseLabel, String courseValue)
        {
            this.courseLabel = courseLabel;
            this.courseValue = courseValue;
        }
        
        public String getCourseLabel()
        {
            return courseLabel;
        }
        
        public String getCourseValue()
        {
            return courseValue;
        }
    }    

}