package znidarsic_c_hw7;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table (name="REGISTRAR")
public class RegistrarEntity {
	
	@Id
	@Column (name = "COURSE_ID")
	private String courseId;
	
	@Column (name = "NUMBER_REGISTERED")
	private int numberRegistered;
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getNumberRegistered() {
		return numberRegistered;
	}
	public void setNumberRegistered(int numberRegistered) {
		this.numberRegistered = numberRegistered;
	}
	
}
