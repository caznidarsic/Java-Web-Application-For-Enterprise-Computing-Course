package znidarsic_c;
import java.io.Serializable;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
//import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
//import javax.faces.bean.SessionScoped;
//import javax.faces.bean.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class CheckRegistrationSupportBean implements Serializable{
	
//	static final long serialVersionUID = 123;
    private ArrayList<RegistrationResult> courseData;
    private String inputName;
    private String message = "";


    public ArrayList<RegistrationResult> getCourseData() {
		return courseData;
	}
	public void setCourseData(ArrayList<RegistrationResult> courseData) {
		this.courseData = courseData;
	}
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}


	public void getRegData() {
		this.setCourseData(PersistenceUtility.getRegDataLastName(inputName));
		if (courseData.isEmpty()) {
			this.message = "There are no course registrations associated with last name: " + inputName;
		}
		else {
			this.message = "";
		}
    }

    
    
    
      

}