package cznidarsic;

import java.util.ArrayList;
import java.util.List;

public class Courses {
	
	public static List<Course> courses;
	
	static {
		courses.add(new Course("605.111", "Intro to Studies", 20, 17));
		courses.add(new Course("605.222", "Intro to Advanced Studies", 20, 20));
		courses.add(new Course("605.333", "Advanced Studies", 25, 21));
		courses.add(new Course("605.444", "Intro to Advanced Studies of Advanced Studies", 20, 20));
	}
	
	public static List<Course> getCourses() {
		return courses;
	}
}
