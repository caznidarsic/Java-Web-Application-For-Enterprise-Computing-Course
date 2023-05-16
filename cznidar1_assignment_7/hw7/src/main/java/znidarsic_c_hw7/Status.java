package znidarsic_c_hw7;

import javax.ejb.Stateless;
//import javax.naming.Context;
//import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import javax.sql.DataSource;

import java.util.ArrayList;
//import java.util.Hashtable;
import java.util.List;
//import java.sql.*;

@Stateless

public class Status {
	
	public ArrayList<String[]> getStatus(String[] input) {
		ArrayList<String[]> output = new ArrayList<String[]>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        
        String query = "SELECT COURSES.COURSE_ID, COURSES.COURSE_TITLE, REGISTRAR.NUMBER_REGISTERED FROM COURSES NATURAL JOIN REGISTRAR WHERE COURSES.COURSE_ID IN (";
		 for (int x = 0; x < input.length; x++) {
			 if (x != input.length-1) {
				 query += "'" + input[x] + "', ";
			 }
			 else {
				 query += "'" + input[x] + "'";
			 }
		 }
		 query += ")";
        
        Query nativeQuery = entityManager.createNativeQuery(query);
        List<Object[]> resultList = nativeQuery.getResultList();        
        
        for (Object[] courseEntity : resultList) {
        	output.add(new String[] {(String)courseEntity[0], (String)courseEntity[1], Integer.toString((int)courseEntity[2])});
        }
        
        return output;
        
	}
	
	
	
	public ArrayList<String[]> getAllStatus(String[] input) {
		ArrayList<String[]> output = new ArrayList<String[]>();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
		
        Query nativeQuery = entityManager.createNativeQuery("SELECT COURSES.COURSE_ID, COURSES.COURSE_TITLE, REGISTRAR.NUMBER_REGISTERED FROM COURSES NATURAL JOIN REGISTRAR");
        List<Object[]> resultList = nativeQuery.getResultList();
        
        for (Object[] courseEntity : resultList) {
        	output.add(new String[] {(String)courseEntity[0], (String)courseEntity[1], Integer.toString((int)courseEntity[2])});
        }
        
		return output;
	}
	
	
	
	
	public boolean coursesExist(String[] courses) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        
		TypedQuery<CourseEntity> query = entityManager.createQuery("SELECT t FROM CourseEntity t", CourseEntity.class);
		List<CourseEntity> resultList = query.getResultList();
		
		ArrayList<String> validCourseIds = new ArrayList<String>();
		
		for (CourseEntity courseEntity : resultList) {
			validCourseIds.add(courseEntity.getCourseId());
		}
		
		for (String inputCourseId : courses) {
			if (!validCourseIds.contains(inputCourseId)) {
				return false;
			}
		}
		return true;
	}
	 
}
