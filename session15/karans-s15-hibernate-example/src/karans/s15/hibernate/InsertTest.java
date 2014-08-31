package karans.s15.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import karans.s15.hibernate.domain.Book;

public class InsertTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Book book = new Book();
		book.setId(100);
		book.setName("Philosophy-II");
		book.setAuthor("Plato");

		Book book2 = new Book();
		book2.setId(100);
		book2.setName("Philosophy-I");
		book2.setAuthor("Socrate");

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);
			session.save(book2);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}

		factory.close();
	}
}
