package karans.s14.hibernate.xmlconf;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddCarTest {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session s = factory.openSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			Car c = new Car();
			c.setId(200);
			c.setName("BMW");
			c.setModel("X3");
			s.save(c);
			t.commit();
			System.out.println("Done.");
		} catch (Exception e) {
			t.rollback();
		} finally {
			s.close();
		}
	}
}
