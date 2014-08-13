package spring_ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"mycontext.xml");
		EchoerCaller caller = (EchoerCaller) context.getBean("caller");
		caller.call();
		caller = (EchoerCaller) context.getBean("caller");
		caller.call();
		caller = (EchoerCaller) context.getBean("caller");
		caller.call();
		caller = (EchoerCaller) context.getBean("caller");

		Echoer e = (Echoer) context.getBean("echoer2");
		e.printName();
		e = (Echoer) context.getBean("echoer");
		e.printName();

		TestClass obj = (TestClass) context.getBean(TestClass.class);
		obj.sayHello();
	}
}
