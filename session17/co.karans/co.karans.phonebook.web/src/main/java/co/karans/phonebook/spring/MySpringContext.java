package co.karans.phonebook.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringContext {

	private static ApplicationContext context;

	static {
		System.out.println("Creating spring context ...");
		context = new ClassPathXmlApplicationContext("spring-beans.xml");
		System.out.println("Spring context is created.");
	}

	public static ApplicationContext getContext() {
		System.out.println("Returning spring context ...");
		return context;
	}
}
