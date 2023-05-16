package znidarsic_c;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;	
import javax.ejb.EJBException;

import znidarsic_c.RegistrarCourseBean;

@WebServlet("/ejbclient")
public class EjbClientServlet extends HttpServlet {

    private static final String SHORT_RUNNING_MODE = "S";
    private static final String LONG_RUNNING_MODE = "L";
    private static String _mode = "S";

    @EJB  
    RegistrarCourseBean ejb_slsb;

    public EjbClientServlet () {
        super();
    }
 
    // Method to handle GET method request
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
           doPost(request, response);
    }
    
    // Method to handle POST method request
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("****************  About to call processTransaction()");

            String transactionOutput = processTransaction();

        System.out.println("****************  Back from processTransaction()");

        // Set response content type
           resp.setContentType("text/html");
 
           PrintWriter out = resp.getWriter(); 

           out.println(
            "<html>\n" + 
               "<body bgcolor = \"#f0f0f0\">\n" +
                  "<br>" + transactionOutput  +
                  "<br>Click <a href='index.html'>here</a> to go to main page</br>" +
               "</body>" +
            "</html>"
          );
          return;
    }

    private String processTransaction () {

      System.out.println( "******************  in EjbClientServlet, processTransaction ()");

      StringBuilder sb = new StringBuilder();

      int _loopCount = 1;

        for (int i = 1; i <= 4; i++) {

            String output = String.format("<br>--- Starting transaction %d of %d, mode = %s ---<br>", i, 4, _mode);
            
            sb.append(output);

            // Fetch number of Property records in DB before INSERT 
            int numberOfRecords = getNumberOfRecords();

            output = String.format("<br>Number of records before INSERT = %d ", numberOfRecords);
            
            sb.append(output);

            String insertRecord = "Loop # " + Integer.toString(i); 

            // Run transaction
            try {
                if (_mode.equals(SHORT_RUNNING_MODE)) {
                  
                    output = "<br>Inserting new record in short-running mode";
                  
                    sb.append(output);
                  
                    ejb_slsb.insertShort(insertRecord); 

                } else {

                    output = "<br>Inserting new record in long-running mode";

                    sb.append(output);

                    ejb_slsb.insertLong(insertRecord); 

                }
            } catch (EJBException ex) {
                output = "<br>* An EJBException was encountered *";
                sb.append(output);              
            } catch (Exception ex) {
                output = "<br>* An Exception was encountered * ";                
                sb.append(output);
              }
            
            // Fetch registration count after INSERT
            numberOfRecords = getNumberOfRecords();

            output = String.format("<br> Number of records aftder INSERT = %d", numberOfRecords);

            sb.append(output);

            // Done transaction. Switch mode.

            this.switchMode();
            output = String.format("<br>Done transaction. Switched mode to %s<br>", _mode);

            sb.append(output);
        
        }

        return sb.toString();

  } // end of processTransaction method

  private int getNumberOfRecords() {
        System.out.println("in getNumberOfRecords");
        return ejb_slsb.numberOfRecords();
    }
  
  private void switchMode() {
        _mode = (_mode.equals(SHORT_RUNNING_MODE)) ? LONG_RUNNING_MODE : SHORT_RUNNING_MODE;
  }
      
}

