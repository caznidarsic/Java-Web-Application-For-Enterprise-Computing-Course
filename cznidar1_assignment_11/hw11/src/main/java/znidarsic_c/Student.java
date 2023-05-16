package znidarsic_c;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;


@Entity
@Table(name="STUDENT")
@DiscriminatorValue("1")
public class Student extends Person {
    
    @Column (name="PASSWORD")
    private String password;
    
    @Column (name="SSN")
    private String ssn;
    
    @Column (name="EMAIL")
    private String email;
    
    @Column (name="LEVEL")
    private String level;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

}  