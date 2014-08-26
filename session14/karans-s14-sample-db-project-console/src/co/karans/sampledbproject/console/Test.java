package co.karans.sampledbproject.console;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.karans.sampledbproject.dao.impl.DefaultPersonDao;
import co.karans.sampledbproject.domain.Person;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"springContext.xml");
		Person p = new Person();
		p.setName("Alex");
		p.setId(200);
		new DefaultPersonDao().insert(p);
		System.out.println("Person is added.");
	}
}
