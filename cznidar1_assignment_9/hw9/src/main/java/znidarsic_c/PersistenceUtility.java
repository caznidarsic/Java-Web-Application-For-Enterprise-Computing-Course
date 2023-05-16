package znidarsic_c;

import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import znidarsic_c.Student;

public class PersistenceUtility {
	
	public static void persistStudent(Student student) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(student);
		
		entityManager.getTransaction().commit();
		
	}
	
	public static Person getPerson(String userId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		TypedQuery<Person> q = entityManager.createQuery("select t from Person t where t.userId = '" + userId + "'", Person.class);
		return q.getSingleResult();
		
	}
	
	public static Student getStudent(String userId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		TypedQuery<Student> q = entityManager.createQuery("select t from Student t where t.userId = '" + userId + "'", Student.class);
		return q.getSingleResult();
		
	}
	
	
//	public static CourseEntity getCourse(String courseId) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
//		EntityManager entityManager = emf.createEntityManager();
//		entityManager.getTransaction().begin();
//		
//		TypedQuery<CourseEntity> q = entityManager.createQuery("select t from CourseEntity t where t.courseId = '" + courseId + "'", CourseEntity.class);
//		return q.getSingleResult();
//	}
	
	public static CourseEntity getCourse(String courseId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CourseEntity> cq = cb.createQuery(CourseEntity.class);
		Root<CourseEntity> courseEntity = cq.from(CourseEntity.class);
		cq.select(courseEntity).where(cb.equal(courseEntity.get("courseId"), courseId));
		TypedQuery<CourseEntity> q = em.createQuery(cq);
		return q.getSingleResult();
	}
	
	
	public static void updateCourseRegistration(String courseId, int numRegistered) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		TypedQuery<CourseEntity> q = entityManager.createQuery("select t from CourseEntity t where t.courseId = '" + courseId + "'", CourseEntity.class);
		CourseEntity course = q.getSingleResult();
		course.setNumRegistered(numRegistered);
		
		
		entityManager.getTransaction().commit();
		
	}
	
	public static void persistRegistrarEntity(RegistrarEntity regEntity) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(regEntity);
		
		entityManager.getTransaction().commit();
		
	}
	
	public static boolean alreadyRegistered(String userId, String courseId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
		
		String jpqlString = "select r from RegistrarEntity r where r.userId = :userId and r.courseId = :courseId";
		TypedQuery<RegistrarEntity> query = entityManager.createQuery(jpqlString, RegistrarEntity.class);
		query.setParameter("userId", userId);
		query.setParameter("courseId", courseId);
		
		try {
			RegistrarEntity regEntity = query.getSingleResult();
		} catch (NoResultException e) {
			return false;
		} catch (NonUniqueResultException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static ArrayList<RegistrationResult> getRegDataLastName(String lastname) {
		ArrayList<RegistrationResult> output = new ArrayList<RegistrationResult>();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPersistenceUnit");
		EntityManager entityManager = emf.createEntityManager();
				
		String jpqlString = "SELECT P.firstName, P.lastName, C.courseId, C.courseTitle"
		+ " FROM Person P, CourseEntity C, RegistrarEntity R"
		+ " WHERE P.userId=R.userId AND C.courseId=R.courseId AND P.lastName=:lastName";
		
		Query query = entityManager.createQuery(jpqlString);
		query.setParameter("lastName", lastname);
		
		List<Object[]> resultList = query.getResultList();
		
		for (Object[] result : resultList) {
			output.add(new RegistrationResult((String)result[0], (String)result[1], (String)result[2], (String)result[3]));
		}
		
		return output;
	}
	
	
}





