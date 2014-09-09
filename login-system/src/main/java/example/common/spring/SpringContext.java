package example.common.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext {
 
	private static ApplicationContext context;

	static {
		System.out.println("Making spring context ... ");
		context = new ClassPathXmlApplicationContext("spring-beans.xml");
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
}
