package co.karans.fw.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityDAO<T> {

	private static EntityManager entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("phonebook")
				.createEntityManager();
	}

	public void save(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw e;
		}
	}

	public void update(T entity) {
		// TODO
	}

	public void delete(T entity) {
		// TODO
	}

	public List<T> getAll() {
		// TODO
		return null;
	}
}
