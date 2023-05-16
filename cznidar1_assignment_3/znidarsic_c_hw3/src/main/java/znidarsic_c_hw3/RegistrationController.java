package znidarsic_c_hw3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class mvc_servlet
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
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

    	if (request.getParameter("formname").equals("formA")) {
    		
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
            	
            	log("inputs are valid");
            	
	            UserBean tempobj = new UserBean();
	            tempobj.setUserid(userid);
	            tempobj.setPassword(password);
	            tempobj.setFirstname(firstname);
	            tempobj.setLastname(lastname);
	            tempobj.setSsn(ssn);
	            tempobj.setEmail(email);
	            
	            session.setAttribute("gurubean",tempobj);
	            request.setAttribute("errorMessage", "none");
	            RequestDispatcher rd=request.getRequestDispatcher("FormB.jsp");
	            rd.forward(request, response);
	            
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
            	
            	UserBean tempobj = (UserBean)session.getAttribute("gurubean");
	            tempobj.setAddress(address);
	            tempobj.setCity(city);
	            tempobj.setState(state);
	            tempobj.setZipcode(zipcode);
	            
	            session.setAttribute("gurubean", tempobj);
	            UserBean returnobj = (UserBean)session.getAttribute("gurubean");
	            log("userid: " + returnobj.getUserid());
	            log("password: " + returnobj.getPassword());
	            log("firstname: " + returnobj.getFirstname());
	            log("lastname: " + returnobj.getLastname());
	            log("ssn: " + returnobj.getSsn());
	            log("email: " + returnobj.getEmail());
	            log("address: " + returnobj.getAddress());
	            log("city: " + returnobj.getCity());
	            log("state: " + returnobj.getState());
	            log("zipcode: " + returnobj.getZipcode());
	            
	            request.setAttribute("gurubean", tempobj);
	            RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
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
