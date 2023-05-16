package znidarsic_c_hw4;

public class InputValidation {
	
	/*
	 * Requirements for userId:
	 * 1. Between 8 and 20 characters long
	 * 2. Only contains upper/lower case letters, and numbers 0-9, 
	 */
	public static boolean isValidUserid(String userId) {
		if (userId.matches("^[A-Za-z0-9]{8,20}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for password:
	 * 1. Between 8 and 20 characters long
	 * 2. Only contains upper/lower case letters, numbers 0-9, and non-word characters.
	 */
	public static boolean isValidPassword(String password) {
		if (password.matches("^[A-Za-z0-9\\W]{8,20}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for firstname:
	 * 1. Between 1 and 20 characters long
	 * 2. Only contains upper/lower case letters.
	 */
	public static boolean isValidFirstname(String firstname) {
		if (firstname.matches("^[A-Za-z]{1,20}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for lastname:
	 * 1. Between 1 and 20 characters long
	 * 2. Only contains upper/lower case letters.
	 */
	public static boolean isValidLastname(String lastname) {
		if (lastname.matches("^[A-Za-z]{1,20}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for ssn:
	 * 1. 9 characters long
	 * 2. Only contains numbers
	 */
	public static boolean isValidSsn(String ssn) {
		if (ssn.matches("^[0-9]{9}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for email:
	 * 1. 1-64 characters followed by '@' followed by 1-255 characters
	 * 2. Contains letters/numbers/non-word characters, followed by '@', followed by letters/numbers/non-word characters
	 */
	public static boolean isValidEmail(String email) {
		if (email.matches("^[A-Za-z0-9\\W]{1,64}\\@[A-Za-z0-9\\W]{1,255}$")) {
			return true;
		}
		return false;
	}
	
	public static boolean passwordsMatch(String pass1, String pass2) {
		if (pass1.equals(pass2)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for address:
	 * 1. 1-64 characters
	 * 2. Contains letters/numbers and '.' characters and spaces only
	 */
	public static boolean isValidAddress(String address) {
		if (address.matches("^[A-Za-z0-9\\.\\s]{1,64}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for city:
	 * 1. 1-64 characters
	 * 2. Contains letters and spaces only
	 */
	public static boolean isValidCity(String city) {
		if (city.matches("^[A-Za-z\\s]{1,64}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for state:
	 * 1. 2 characters
	 * 2. Contains upper-case letters only
	 */
	public static boolean isValidState(String state) {
		if (state.matches("^[A-Z]{2}$")) {
			return true;
		}
		return false;
	}
	
	/*
	 * Requirements for zipcode:
	 * 1. 5 characters
	 * 2. Contains numbers only
	 */
	public static boolean isValidZipcode(String zipcode) {
		if (zipcode.matches("^[0-9]{5}$")) {
			return true;
		}
		return false;
	}
	
}
