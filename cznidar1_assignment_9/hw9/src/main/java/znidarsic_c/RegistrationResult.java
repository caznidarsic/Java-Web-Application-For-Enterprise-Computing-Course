package znidarsic_c;

public class RegistrationResult {
	private String firstName;
	private String lastName;
	private String courseId;
	private String courseName;
	
	public RegistrationResult(String _firstName, String _lastName, String _courseId, String _courseName) {
		this.firstName = _firstName;
		this.lastName = _lastName;
		this.courseId = _courseId;
		this.courseName = _courseName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}