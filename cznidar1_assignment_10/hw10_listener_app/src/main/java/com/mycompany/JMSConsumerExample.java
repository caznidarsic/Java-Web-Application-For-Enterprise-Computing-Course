package com.mycompany;

   import java.util.Properties;
   import javax.jms.*;
   import javax.naming.*;

public class JMSConsumerExample  {

    // Set up all the default values

    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "jms/topic/RegCourseTopic";
    private static final String DEFAULT_USERNAME = "mquser";
    private static final String DEFAULT_PASSWORD = "mqpassword";
    private static final String INITIAL_CONTEXT_FACTORY = "org.wildfly.naming.client.WildFlyInitialContextFactory";
    private static final String PROVIDER_URL = "http-remoting://127.0.0.1:8080";

    public static void main(String[] args) {

        Context namingContext = null;
        Connection conn = null;
        ConnectionFactory connectionFactory = null;
        Session session = null;    

      try {
            String userName = System.getProperty("username", DEFAULT_USERNAME);
            String password = System.getProperty("password", DEFAULT_PASSWORD);

            // Set up the namingContext for the JNDI lookup
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
            env.put(Context.SECURITY_PRINCIPAL, userName);
            env.put(Context.SECURITY_CREDENTIALS, password);
            namingContext = new InitialContext(env);

            // Perform the JNDI lookups
            String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
            connectionFactory = (ConnectionFactory) namingContext.lookup(connectionFactoryString);

        } catch (NamingException e) {
             e.printStackTrace();   
        }  

        try {

            conn = connectionFactory.createConnection("mquser", "mqpassword");
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
            Queue queue = session.createQueue("testQueue");
            Topic topic = session.createTopic(DEFAULT_CONNECTION_FACTORY);
 
            // Consumer
            MessageConsumer consumer = session.createConsumer(topic);
            conn.start();            

            while (true) {
                // TextMessage textMsg = (TextMessage) consumer.receive();
                MapMessage mapMessage = (MapMessage) consumer.receive();
                // System.out.println(mapMessage);
                System.out.print("User_ID: " + mapMessage.getString("User_ID") + ", ");
                System.out.print("Course_ID: " + mapMessage.getString("Course_ID") + ", ");
                System.out.print("Course_Name: " + mapMessage.getString("Course_Name") + ", ");
                System.out.println("Date_of_Registration: " + mapMessage.getString("Date_of_Registration"));
                // System.out.println("Received: " + mapMessage.getText());
                // if (mapMessage.getText().equals("END")) {
                //     break;
                // }
            } // while

        }  catch (JMSException e) {
             e.printStackTrace();
             
        }   finally {
                // System.out.println("END!!!");
            
            }  // finally

    }  //end of main

}   //end of class



