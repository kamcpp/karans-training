package example.common.spring;

import org.springframework.context.ApplicationContext;

public class SpringContext {
 
	private static ApplicationContext context;

	static {
		// TODO
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
}
