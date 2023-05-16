package znidarsic_c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		HelloWorld2 obj2 = (HelloWorld2) context.getBean("helloWorld2");
		obj.getMessage();
		obj2.getMessage();
		
		// Closing the context calls the destroy() methods of all the beans in the container.
		((ConfigurableApplicationContext)context).close();
	}
}
