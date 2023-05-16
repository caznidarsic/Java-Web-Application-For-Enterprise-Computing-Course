package znidarsic_c_hw7;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;


@Entity
@Table (name="COURSES")
public class CourseEntity {
	
	@Id
	@Column (name = "COURSE_ID")
	private String courseId;
	
	@Column (name = "COURSE_TITLE")
	private String courseTitle;
	
	@Column (name = "MAX_REGISTERED")
	private int maxRegistered;
	
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public int getMaxRegistered() {
		return maxRegistered;
	}
	public void setMaxRegistered(int maxRegistered) {
		this.maxRegistered = maxRegistered;
	}
	
}
