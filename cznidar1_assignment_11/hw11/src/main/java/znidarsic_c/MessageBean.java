package znidarsic_c;  
import javax.ejb.MessageDriven;  
import javax.jms.*;  
import javax.ejb.ActivationConfigProperty;

@MessageDriven(mappedName = "jms/topic/RegCourseTopic",
		activationConfig={
        @ActivationConfigProperty(propertyName = "destination", propertyValue="jms/topic/RegCourseTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue="javax.jms.Topic"),        
        @ActivationConfigProperty(propertyName = "user", propertyValue = "mquser"),
        @ActivationConfigProperty(propertyName = "password", propertyValue = "mqpassword"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MessageBean implements MessageListener{  
	
	
    @Override  
    public void onMessage(Message msg) {  
        MapMessage mapMessage = (MapMessage) msg;  
        try {  
            System.out.print("User_ID: " + mapMessage.getString("User_ID") + ", ");
            System.out.print("Course_ID: " + mapMessage.getString("Course_ID") + ", ");
            System.out.print("Course_Name: " + mapMessage.getString("Course_Name") + ", ");
            System.out.println("Date_of_Registration: " + mapMessage.getString("Date_of_Registration"));
        } catch(Exception e) {
        	System.out.println(e);
        }  
    }  
}  