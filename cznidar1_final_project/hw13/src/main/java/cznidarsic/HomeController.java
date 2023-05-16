package cznidarsic;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
	private static List<Course> courses = new ArrayList<Course>();
	
	static {
		courses.add(new Course("605.111", "Intro to Studies", 20, 17));
		courses.add(new Course("605.222", "Intro to Advanced Studies", 20, 20));
		courses.add(new Course("605.333", "Advanced Studies", 25, 21));
		courses.add(new Course("605.444", "Intro to Advanced Studies of Advanced Studies", 20, 20));
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	
	public String helloClass() {

		System.out.println("MADE IT INTO HELLOCLASS()");
		return "welcome";
	
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	
	public String registerGet(Model model) {
		ShowCoursesForm coursesForm = new ShowCoursesForm();
		coursesForm.setCourses(courses);
		model.addAttribute("Courses", coursesForm);
		
		
		System.out.println("MADE IT INTO register()");
		return "register";
	
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	
	public String registerPost(@ModelAttribute("courseSelection") String courseSelection, Model model) {
		
		ShowCoursesForm coursesForm = new ShowCoursesForm();
		coursesForm.setCourses(courses);
		model.addAttribute("Courses", coursesForm);

		for (Course course : courses) {
			if (course.getNumber().equals(courseSelection)) {
				if (course.getNumRegistered() >= course.getCapacity()) {
					model.addAttribute("message", "Sorry, the course you have selected is full. You have been added to the waitlist for the course: " + courseSelection);
				}
				else {
					model.addAttribute("message", "You have been registered for the course: " + courseSelection);
				}
				return "register";
			}
		}
		model.addAttribute("message", "The requested course does not exist: " + courseSelection);
		return "register";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	
	public String update(Model model) {
		model.addAttribute("userform", new User("sampleuser123", "Albert", "Smith", LocalDate.parse("1998-01-02"), "368 Sample Pl", "Palo Alto", "CA", "12345"));
		
		System.out.println("MADE IT INTO update()");
		return "update";
	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	
	public String updatePost(@Valid @ModelAttribute("userform") User user, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println(result.getFieldErrors());
			return "update";
		}
		else {
			return "success";
		}	
	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	
	public String success() {
		return "success";
	
	}
	
	
}