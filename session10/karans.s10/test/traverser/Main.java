package traverser;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import traverser.khaleghi.impl.FileSizeAggregator;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"mycontext.xml");
		TraverseExecuter executer = context.getBean(TraverseExecuter.class);
		executer.execute();
		System.out.println(((FileSizeAggregator) context.getBean("xyz"))
				.getResult());
	}
}
