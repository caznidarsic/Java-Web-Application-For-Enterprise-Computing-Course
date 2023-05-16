package znidarsic_c;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType; 
import javax.persistence.Query;
//import javax.ejb.TransactionAttribute;
//import javax.ejb.TransactionAttributeType;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;


@Singleton
@TransactionAttribute(TransactionAttributeType.SUPPORTS)

@TransactionManagement(value= TransactionManagementType.CONTAINER)
public class  RegistrarCourseBean   {
  
 @PersistenceContext(unitName = "testPersistenceUnit")
 private EntityManager em;
 
 @TransactionAttribute(TransactionAttributeType.REQUIRED)
 public String insertShort(RegistrarEntity regEntity) throws  Exception {

             System.out.println("............ in SingleTonBean insertShort method !!!!!!!!!!!!!!!!!!!");
 
     int i = numberOfRecords();

             System.out.println("Number of records = " + Integer.toString(i));

     queryNative(em);
    
//     Property p = new Property();
//     p.setKey(input);
//     p.setValue(input);
//     RegistrarEntity re = new RegistrarEntity();
//     re.setUserId(input);
//     re.setCourseId(input);

             System.out.println("Property object is instantiated !!!!!!!!!!!!!!!!!!!!!!!!!!!!");

//     em.persist(p);
     em.persist(regEntity);
     em.flush();

             System.out.println("Just did PERSIST and FLUSH !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

     return("return from insertShort method");  
  }

 @TransactionAttribute(TransactionAttributeType.REQUIRED)
 public String insertLong(RegistrarEntity regEntity) throws  Exception {

             System.out.println("............ in SingleTonBean insertLong method !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
 
     int i = numberOfRecords();

             System.out.println("Number of records = " + Integer.toString(i));

     queryNative(em);
    
    try {
 
//        Property p = new Property();
//        p.setKey(input);
//        p.setValue(input);
//        RegistrarEntity re = new RegistrarEntity();
//        re.setUserId(input);
//        re.setCourseId(input);

             System.out.println("Property object is instantiated !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        Thread.sleep(4000); // 4 seconds

//        em.persist(p);
        em.persist(regEntity);
        em.flush();

    } catch (EJBException e) {

              System.out.println("EJBEXCEPTION !!!!!!!!!!!!!!!!!!! TIMEOUT ...... SO, THROWING Exception(e) !!!!!!!!!!!");
              throw new Exception(e);
      } catch (Exception e) {

                  System.out.println("THROWING EXCEPTION !!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                  return ("I got Exception");
        }
     return( "return from insertLong method");  
  }

    public void queryNative(EntityManager entityManager) {
        
                System.out.println("----\nnative query");
        
//        Query nativeQuery = entityManager.createNativeQuery("select * from Property");
        Query nativeQuery = entityManager.createNativeQuery("select * from REGISTRAR");
        List resultList = nativeQuery.getResultList();
 
        for (Object o : resultList) {
            if (o.getClass().isArray()) {
                Object oa[] = (Object[]) o;
                System.out.println("Array as List ..................." + Arrays.asList(oa));
            } else {
                System.out.println("Array is not list .................." + o);
            }
        }
    } // end of queryNative

    public int numberOfRecords () {
        System.out.println("----\nnative query ...... numberOfRecords");
//        Query nativeQuery = em.createNativeQuery("select count(*) from Property");
        Query nativeQuery = em.createNativeQuery("select count(*) from REGISTRAR");
        
        return nativeQuery.getSingleResult() != null ? Integer.parseInt(nativeQuery.getSingleResult().toString()) : 0;
    } // end of numberOfRecords 
}
