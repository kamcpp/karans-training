package karans.s15.hibernate;

import java.util.List;

import karans.s15.hibernate.domain.Book;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SelectTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder
				.build());

		Session session = factory.openSession();

		Query q = session
				.createQuery("from Book b where b.name like 'Philosophy%'");
		List<Book> books = (List<Book>) q.list();

		for (Book b : books) {
			System.out.println(b.getName());
		}
		
		factory.close();
	}
}
