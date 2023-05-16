package znidarsic_c;

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
	
	@Column (name = "USER_ID")
	private String userId;
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
