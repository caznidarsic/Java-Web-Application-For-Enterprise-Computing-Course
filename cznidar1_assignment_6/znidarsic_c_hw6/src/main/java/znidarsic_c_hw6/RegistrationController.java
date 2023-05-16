package znidarsic_c_hw6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 * Servlet implementation class mvc_servlet
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	@EJB Status statusBean;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//default doGet()
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    	
    	HttpSession session = request.getSession(true);
    	
    	if (request.getParameter("formname").equals("login")) {
    		if (request.getParameter("selection").equals("Log In")) {
        		String userid=request.getParameter("userid");  
                String password=request.getParameter("password");
        		
            	DBConnection dbc = new DBConnection();
            	if (dbc.isValidLogin(userid, password)) {
            		request.setAttribute("errorMessage", "none");
//            		request.setAttribute("userId", userid);
            		session.setAttribute("userid", userid);
    	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
    	            rd.forward(request, response);
            	}
            	else {
//            		request.setAttribute("errorMessage", "invalid login credentials.");
    	            RequestDispatcher rd=request.getRequestDispatcher("LoginFailure.jsp");
    	            rd.forward(request, response);
            	}
    		}
    		else {
	            RequestDispatcher rd=request.getRequestDispatcher("FormA.jsp");
	            rd.forward(request, response);
    		}
    	}
    	
    	
    	else if (request.getParameter("formname").equals("loginfailure")) {
    		if (request.getParameter("failradio").equals("Login")) {
    			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
    		}
    		else {
    			RequestDispatcher rd=request.getRequestDispatcher("FormA.jsp");
                rd.forward(request, response);
    		}
    	}
    	
    	else if (request.getParameter("formname").equals("welcome")) {
    		if (request.getParameter("welcomeradio") == null) {
//    			String userid = request.getParameter("userid");
    			String userid = (String)session.getAttribute("userid");
        		request.setAttribute("userId", userid);
	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
	            rd.forward(request, response);
    		}
    		else if (request.getParameter("welcomeradio").equals("logout")) {
	            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
	            rd.forward(request, response);
    		}
    		
    		
    		
    		else if (request.getParameter("welcomeradio").equals("status")) {
    			DBConnection dbc = new DBConnection();
    			ArrayList<String[]> courses = new ArrayList<String[]>();
    			courses = dbc.getAll("COURSES", "COURSE_ID", "COURSE_TITLE");
    			request.setAttribute("courses", courses);
	            RequestDispatcher rd=request.getRequestDispatcher("Status.jsp");
	            rd.forward(request, response);
    		}
    		
    		
    		
    		else if (request.getParameter("welcomeradio").equals("register")){
    			// THIS WILL CONTAIN COURSE REGISTRATION FUNCTIONALITY
    			String userid = request.getParameter("userid");
        		request.setAttribute("userId", userid);
	            RequestDispatcher rd=request.getRequestDispatcher("Registration.xhtml");
	            rd.forward(request, response);
    		}
    		else {
    			String userid = request.getParameter("userid");
        		request.setAttribute("userId", userid);
	            RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
	            rd.forward(request, response);
    		}
    	}
    	
    	
    	else if (request.getParameter("formname").equals("formA")) {
    		
    		String userid=request.getParameter("userid");  
            String password=request.getParameter("password");
            String passwordrepeat = request.getParameter("passwordrepeat");
    		String firstname=request.getParameter("firstname");  
            String lastname=request.getParameter("lastname");
    		String ssn=request.getParameter("ssn1") + request.getParameter("ssn2") + request.getParameter("ssn3");  
            String email=request.getParameter("email");
            
            /*
             * Error checking in case of forced inputs.
             */
            if (userid.equals(null) || password.equals(null) || firstname.equals(null) || lastname.equals(null) || ssn.equals(null) || email.equals(null)) {
            	log("missing parameter");
            	request.setAttribute("errorMessage", "missing parameters.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);

            }
            else if (!InputValidation.isValidUserid(userid)) {
            	log("invalid userid");
            	request.setAttribute("errorMessage", "invalid UserId.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            	
            }
            else if (!InputValidation.isValidPassword(password)) {
            	log("invalid password");
            	request.setAttribute("errorMessage", "invalid Password.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            else if (!InputValidation.isValidFirstname(firstname)) {
            	log("invalid username");
            	request.setAttribute("errorMessage", "invalid Firstname.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            else if (!InputValidation.isValidLastname(lastname)) {
            	log("invalid lastname");
            	request.setAttribute("errorMessage", "invalid Lastname.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            else if (!InputValidation.isValidSsn(ssn)) {
            	log("invalid ssn");
            	request.setAttribute("errorMessage", "invalid Ssn.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            else if (!InputValidation.isValidEmail(email)) {
            	log("invalid email");
            	request.setAttribute("errorMessage", "invalid Email.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            else if (!InputValidation.passwordsMatch(password, passwordrepeat)) {
            	log("passwords do not match");
            	request.setAttribute("errorMessage", "passwords do not match.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            
            else {
//            	log("inputs are valid");
            	
            	//UPDATE DATABASE
//            	DBConnection dbc = new DBConnection();
//            	dbc.isValidLogin(userid, password);
            	
            
            	DBConnection dbc = new DBConnection();
            	if (dbc.addNewStudent(userid).equals("userId set")) {

            		dbc.setValue(userid, "Password", password);
            		dbc.setValue(userid, "First_Name", firstname);
            		dbc.setValue(userid, "Last_Name", lastname);
            		dbc.setValue(userid, "SSN", ssn);
            		dbc.setValue(userid, "Email", email);            		
    	            
    	            request.setAttribute("errorMessage", "none");
//    	            request.setAttribute("userId", userid);
    	            session.setAttribute("userid", userid);
    	            RequestDispatcher rd=request.getRequestDispatcher("FormB.jsp");
    	            rd.forward(request, response);
            	}
            	else {
            		request.setAttribute("errorMessage", "userId already exists.");
    	            RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
    	            rd.forward(request, response);
            	}
	            
            }
            
    	}
    	
    	else if (request.getParameter("formname").equals("formB")) {
    		String address=request.getParameter("address");  
            String city=request.getParameter("city");
    		String state=request.getParameter("state");  
            String zipcode=request.getParameter("zipcode");
            
            
            if (address.equals(null) || city.equals(null) || state.equals(null) || zipcode.equals(null)) {
            	log("missing parameter");
            	request.setAttribute("errorMessage", "missing parameters.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            }
            
            else if (!InputValidation.isValidAddress(address)) {
            	log("invalid address");
            	request.setAttribute("errorMessage", "invalid Address.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            	
            }
            
            else if (!InputValidation.isValidCity(city)) {
            	log("invalid city");
            	request.setAttribute("errorMessage", "invalid City.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            	
            }
            
            else if (!InputValidation.isValidState(state)) {
            	log("invalid state");
            	request.setAttribute("errorMessage", "invalid State.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            	
            }
            
            else if (!InputValidation.isValidZipcode(zipcode)) {
            	log("invalid zipcode");
            	request.setAttribute("errorMessage", "invalid Zipcode.");
            	RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            	rd.forward(request, response);
            	
            }

            else {
            	
            	System.out.println("ATTRIBUTE IS: " + session.getAttribute("userid"));
            	DBConnection dbc = new DBConnection();
            	
            	String userid = (String)session.getAttribute("userid");
        		dbc.setValue(userid, "Address", address + " " + city + " " + state + " " + zipcode);
            	

        		request.setAttribute("userId", userid);
	            RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
	            rd.forward(request, response);
	            
            }
    	}
    	
    	else if (request.getParameter("formname").equals("statusForm")) {
    		if (request.getParameter("selection").equals("Submit")) {
	    		if (request.getParameterValues("inputs") != null) {
	    			if (statusBean.coursesExist(request.getParameterValues("inputs"))) {
		    			ArrayList<String[]> ejbCourseData = statusBean.getStatus(request.getParameterValues("inputs"));
		    			request.setAttribute("ejbCourseData", ejbCourseData);
		    			
		    			DBConnection dbc = new DBConnection();
		    			ArrayList<String[]> courses = new ArrayList<String[]>();
		    			courses = dbc.getAll("COURSES", "COURSE_ID", "COURSE_TITLE");
		    			request.setAttribute("courses", courses);
		    			RequestDispatcher rd=request.getRequestDispatcher("Status.jsp");
		                rd.forward(request, response);
	    			}
	    			else {
	    				request.setAttribute("errorMessage", "one or more courseId values are invalid.");
		    			RequestDispatcher rd=request.getRequestDispatcher("Error.jsp");
		                rd.forward(request, response);
	    			}
	    			
	    		}
	    		else {
	    			ArrayList<String[]> ejbCourseData = statusBean.getAllStatus(request.getParameterValues("inputs"));
	    			request.setAttribute("ejbCourseData", ejbCourseData);
	    			
	    			DBConnection dbc = new DBConnection();
	    			ArrayList<String[]> courses = new ArrayList<String[]>();
	    			courses = dbc.getAll("COURSES", "COURSE_ID", "COURSE_TITLE");
	    			request.setAttribute("courses", courses);
	    			
	    			RequestDispatcher rd=request.getRequestDispatcher("Status.jsp");
	                rd.forward(request, response);
	    		}
    		}
    		else if (request.getParameter("selection").equals("Back")) {
    			RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
                rd.forward(request, response);
    		}
    	}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
