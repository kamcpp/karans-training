package karans.s14.phonebook;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session session = new Configuration().configure().buildSessionFactory()
				.openSession();

		Person person = new Person();
		person.setName("Alex");
		person.setFamily("Alexy");
		person.setAge(22);

		Phone phone1 = new Phone();
		phone1.setNumber("22334455");
		
		Phone phone2 = new Phone();
		phone2.setNumber("44556677");
		
		person.getPhones().add(phone1);
		person.getPhones().add(phone2);
		
		Transaction t = session.getTransaction();
		t.begin();
		session.save(phone1);
		session.save(phone2);
		session.save(person);
		t.commit();

		session.close();

	}
}
