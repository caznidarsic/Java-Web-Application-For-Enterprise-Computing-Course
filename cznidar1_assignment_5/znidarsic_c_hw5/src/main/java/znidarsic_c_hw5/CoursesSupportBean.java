package znidarsic_c_hw5;
import java.io.Serializable;
//import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import java.sql.*;

@Named
@SessionScoped
public class CoursesSupportBean implements Serializable{
	
//	static final long serialVersionUID = 123;
//    private String courseTitle;
//    private String registrationMessage = "";
    private static Map<String, Object> courseTitleValue;
    static
    {
        courseTitleValue = new LinkedHashMap<String, Object>();
        
//        courseTitleValue.put("605.784 Enterprise Computing with Java", "605.784 Enterprise Conputing with Java"); //label, value
//        courseTitleValue.put("605.785 Web Services", "605.785 Web Services");
//        courseTitleValue.put("605.786 Enterprise System Design and Implementation", "605.786 Enterprise System Design and Implementation");
        
        DBConnection dbc = new DBConnection();
        dbc.setSearch("COURSES");
//        System.out.println("SEARCH HAS BEEN SET TO COURSES");
        ResultSet rs = dbc.getResult();
//        System.out.println("RESULTSET HAS BEEN MADE");
        try {
	        while(rs.next()) {
	        	courseTitleValue.put(rs.getString(1) + " " + rs.getString(2), rs.getString(1) + " " + rs.getString(2));
	        }
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
        finally {
        	dbc.closeDBConnection();
        }
        
    }
    

//    public String getcourseTitle() {
//        return courseTitle;
//    }
//    public void setcourseTitle(String courseTitle) {
//        this.courseTitle = courseTitle;
//    }
    
//    public String getRegistrationMessage() {
//    	return registrationMessage;
//    }
//    public void setRegistrationMessage(String registrationMessage) {
//    	this.registrationMessage = registrationMessage;
//    }

    public Map<String, Object> getcourseTitleValue()
    {
        return courseTitleValue;
    }
    
    
    
    
    
    
//    public String registerForCourse() {
//    	//if course is full
//    	this.setRegistrationMessage("You are now registered for " + courseTitle + ".");
//    	
//    	
//    	
//    	return "Registration";
//    }
    
    
    
    
    
    
    
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