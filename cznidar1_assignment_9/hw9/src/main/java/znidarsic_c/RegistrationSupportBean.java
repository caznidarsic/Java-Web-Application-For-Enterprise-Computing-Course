package znidarsic_c;
import java.io.Serializable;
//import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

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