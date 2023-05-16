package znidarsic_c_hw6;
import java.io.Serializable;
//import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ApplicationScoped;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class RegistrationSupportBean implements Serializable{
	
//	static final long serialVersionUID = 123;
    private String courseTitle;
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

//    public Map<String, Object> getcourseTitleValue()
//    {
//        return courseTitleValue;
//    }
    
    
    
    
    
    
    public String registerForCourse() {
    	DBConnection dbc = new DBConnection();
    	String courseId = courseTitle.substring(0, 7);
    	
    	String maxNum = dbc.getValue("COURSES", "COURSE_ID", courseId, "MAX_REGISTERED");
    	String curNum = dbc.getValue("REGISTRAR", "COURSE_ID", courseId, "NUMBER_REGISTERED");
    	try {
    		if (Integer.parseInt(curNum) >= Integer.parseInt(maxNum)) {
	    		this.setRegistrationMessage("Sorry, the registration to this course has been closed based on availability");
	    	}
	    	else {
	    		int newVal = Integer.parseInt(curNum) + 1;
	    		dbc.setNumRegistered(courseId, newVal);
	    		
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