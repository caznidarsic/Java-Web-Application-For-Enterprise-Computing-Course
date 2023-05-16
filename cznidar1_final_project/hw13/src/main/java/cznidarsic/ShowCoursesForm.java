package cznidarsic;

import java.util.List;

public class ShowCoursesForm {
	
	public List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public void print() {
		for (Course course : courses) {
			System.out.println(course.toString());
		}
	}
}