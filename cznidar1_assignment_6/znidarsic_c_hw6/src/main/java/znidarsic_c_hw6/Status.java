package znidarsic_c_hw6;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.Hashtable;
import java.sql.*;

@Stateless

public class Status {
	
	public ArrayList<String[]> getStatus(String[] input) {
		ArrayList<String[]> output = new ArrayList<String[]>();
		DBConnection dbc = new DBConnection();
//		dbc.openDBConnection();
		
		ArrayList<String[]> dbcData = dbc.getSomeFromJoin("COURSES", "REGISTRAR", "COURSE_ID", "COURSE_TITLE", "NUMBER_REGISTERED", "COURSE_ID", input);
		for (String[] outputData : dbcData) {
			output.add(new String[] {outputData[0], outputData[1], outputData[2]});
		}
		
//		dbc.closeDBConnection();

		return output;
	}
	
	public ArrayList<String[]> getAllStatus(String[] input) {
		ArrayList<String[]> output = new ArrayList<String[]>();
		DBConnection dbc = new DBConnection();
//		dbc.openDBConnection();
		
		ArrayList<String[]> dbcData = dbc.getAllFromJoin("COURSES", "REGISTRAR", "COURSE_ID", "COURSE_TITLE", "NUMBER_REGISTERED", "COURSE_ID");
		for (String[] outputData : dbcData) {
			output.add(new String[] {outputData[0], outputData[1], outputData[2]});
		}
		
//		dbc.closeDBConnection();

		return output;
	}
	
	public boolean coursesExist(String[] courses) {
		DBConnection dbc = new DBConnection();
//		dbc.openDBConnection();
		for (String courseId : courses) {
			if (!dbc.courseExists(courseId)) {
				return false;
			}
		}
//		dbc.closeDBConnection();
		return true;
	}
	 
}
