package znidarsic_c;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.SmartInitializingSingleton;

public class HelloWorld2 implements SmartInitializingSingleton, DisposableBean, BeanClassLoaderAware {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	public void getMessage() {
		System.out.println("Your Message : " + message);
	}
	
	/*
	 * This method is referenced in the beans.xml file as the init-method. 
	 * Thus, it is called right after the HelloWorld2 bean is initialized in the container.
	 */
	public void postConstruct() {
		System.out.println("XML CONFIGURED \"init-method\" CALLED ON HelloWorld2 BEAN! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	/*
	 * This method comes from the SmartInitializingSingleton interface from org.springframework.beans.factory.
	 * Thus, it is called automatically when the HelloWorld2 file is initialized in the container.
	 */
	public void afterSingletonsInstantiated() {
		System.out.println("INTERFACE METHOD \"afterSingletonsInstantiated()\" CALLED ON HelloWorld2 BEAN! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	/*
	 * This method is referenced in the beans.xml file as the destroy-method. 
	 * Thus, it is called when the HelloWorld2 bean is destroyed in the container.
	 */
	public void preDestroy() {
		System.out.println("XML CONFIGURED \"destroy-method\" CALLED ON HelloWorld2 BEAN! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	/*
	 * This method comes from the DisposableBean interface from org.springframework.beans.factory.
	 * Thus, it is called automatically when the HelloWorld2 file is destroyed in the container.
	 */
	public void destroy() {
		System.out.println("INTERFACE METHOD \"destroy()\" CALLED ON HelloWorld2 BEAN! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	/*
	 * This method comes from the BeanClassLoaderAware interface from org.springframework.beans.factory.
	 * It is called after the population of normal bean properties but before an initialization callback.
	 */
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("INTERFACE METHOD \"setBeanClassLoader()\" CALLED ON HelloWorld2 BEAN! >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

}
