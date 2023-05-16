package znidarsic_c_hw5;

import java.sql.*;
import java.sql.Connection;
import java.io.IOException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;

public class DBConnection{ 
	
	public  Connection con; 
	public  Statement stm; 
	private String sit = ""; 
    private DataSource ds;
    private ResultSet res;
	
	 public void openDBConnection() { 
		
		Hashtable env = new Hashtable();
	    env.put(Context.INITIAL_CONTEXT_FACTORY, 
	    		"org.wildfly.naming.client.WildFlyInitialContextFactory");
	    
	    try {
	    	// Get a Connection to the database
	    	Context context = new InitialContext(env);
	        ds = (DataSource) context.lookup ("java:jboss/datasources/H2_784_JNDI");
	        con = ds.getConnection("sa", "");
	        stm = con.createStatement(); 
	        sit = "Connection successfully executed"; 
	        
//	        System.out.println("DBCONNECTION OPENED!!!!!!!");
//	        setSearch ( );
	        
	        
	    	  
	        
	    } catch(Exception e) {
	            e.printStackTrace();
	            sit = "Could not connect to the database" + e.getMessage();
		} 
	 } 
	 
	 public void closeDBConnection() { 
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
//			System.out.println("CAN'T CLOSE CON!!!");
		}
		try {
			if (res != null) {
				res.close();
			}
		} catch (Exception e) {
//			System.out.println("CAN'T CLOSE RES!!!");
		}
		try {
			if (stm != null) {
				stm.close();
			}
		} catch (Exception e) {
//			System.out.println("CAN'T CLOSE STM!!!");
		}
		 
	 } 
	 
	
	 public String getSituation(){ 
		return sit; 
		} 
	 
	 
	 //need to add password validation too
	 public boolean isValidLogin(String userId, String password) {
		 try {
			 openDBConnection();
			 ResultSet tempRes = stm.executeQuery("SELECT COUNT(1) FROM STUDENT WHERE User_ID = '" + userId + "'");
			 tempRes.next();
			 if (tempRes.getInt(1) == 1) {
				 tempRes = stm.executeQuery("SELECT PASSWORD FROM STUDENT WHERE User_ID = '" + userId + "'");
				 tempRes.next();
				 if (password.equals(tempRes.getString(1))) {
//					 System.out.println("PASSWORDS MATCH");
					 return true;
				 }
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 closeDBConnection();
//			 System.out.println("DATABASE CONNECTION CLOSED!!!");
		 }
//		 System.out.println("NOT VALID LOGIN");
		 return false;
	 }
	 
	 
	 public String getValue(String table, String primaryKey, String primaryKeyValue, String column) {
		 try {
//			 System.out.println("getValue() called!!!!");
//			 System.out.println("USERID: " + userId);
//			 System.out.println("COLUMN: " + column);
			 openDBConnection();
			 ResultSet tempRes = stm.executeQuery("SELECT " + column + " FROM " + table + " WHERE " + primaryKey + " = '" + primaryKeyValue + "'");
			 
			 tempRes.next();
			 return tempRes.getString(1);
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
			 return null;
		 } finally {
			 closeDBConnection();
//			 System.out.println("DATABASE CONNECTION CLOSED!!!");
		 }
	 }
	 
	 public String addNewStudent(String userId) {
		 try {
			 openDBConnection();
			 
			 ResultSet tempRes = stm.executeQuery("SELECT COUNT(1) FROM STUDENT WHERE User_ID = '" + userId + "'");
			 tempRes.next();
			 if (tempRes.getInt(1) == 1) {
				 return "userId already exists";
			 }
			 stm.executeUpdate("INSERT INTO STUDENT (User_ID) VALUES ('" + userId + "')");
			 return "userId set";
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
			 return "SQLException";
		 } finally {
			 closeDBConnection();
//			 System.out.println("DATABASE CONNECTION CLOSED!!");
		 }
	 }
	 
	 public void setValue(String userId, String column, String value) {
		 try {
			 openDBConnection();
			 stm.executeUpdate("UPDATE STUDENT SET " + column + " = '" + value + "' WHERE User_ID = '" + userId + "';");
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 closeDBConnection();
//			 System.out.println("DATABASE CONNECTION CLOSED!!");
		 }
	 }
	 
	 // takes specified table and sets res to the resultSet containing all info in the specified table
	 public void setSearch(String table) {
		 try {
			 openDBConnection();
			 res = stm.executeQuery("SELECT * FROM " + table);
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void setNumRegistered(String courseId, int num) {
		 try {
			 openDBConnection();
			 stm.executeUpdate("UPDATE REGISTRAR SET NUMBER_REGISTERED = '" + num + "' WHERE Course_ID = '" + courseId + "';");
		 }
		 catch (SQLException e) {
			 e.printStackTrace();
		 } finally {
			 closeDBConnection();
//			 System.out.println("DATABASE CONNECTION CLOSED!!");
		 }
	 }
	 
	 
	 public ResultSet getResult() {
		 return res;
	 }
	 
	 
}



