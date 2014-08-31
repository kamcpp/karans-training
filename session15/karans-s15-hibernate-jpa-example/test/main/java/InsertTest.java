import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Person;

public class InsertTest {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("xyz");
		EntityManager entityManager = factory.createEntityManager();

		Person p = new Person();
		p.setName("Alex");
		p.setFamily("Alexi");
		p.setAge(22);

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(p);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}

		System.out.println(p.getId());

		factory.close();

		System.out.println("Done.");
	}
}
