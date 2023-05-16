package cznidarsic;

//import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Course {
	
	@NotEmpty
	private String Title;
	
	@NotEmpty
	private String Number;
	
	@NotEmpty 
	private int Capacity;
	
	@NotEmpty
	private int NumRegistered;
	
	public Course() { }
	
	public Course (String number, String title, int capacity, int numRegistered) {
		this.Title = title;
		this.Number = number;
		this.Capacity = capacity;
		this.NumRegistered = numRegistered;
	}
	
	public String getTitle() {
		return Title;
	}
	
	public void setTitle (String title) {
		this.Title = title;
	}
	
	public String getNumber() {
		return Number;
	}
	
	public void setEmail(String number) {
		this.Number = number;
	}
	
	public String toString() {
		return Number + " " + Title;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}

	public int getNumRegistered() {
		return NumRegistered;
	}

	public void setNumRegistered(int numRegistered) {
		NumRegistered = numRegistered;
	}
	
}