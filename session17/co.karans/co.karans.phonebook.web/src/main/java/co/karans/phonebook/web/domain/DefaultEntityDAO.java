package co.karans.phonebook.web.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class DefaultEntityDAO<T> implements EntityDAO<T> {

	protected static EntityManager entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("phonebook")
				.createEntityManager();
	}

	@Override
	public void save(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> query = cb.createQuery();
		return (List<T>) entityManager.createQuery(query).getResultList();
	}

	@Override
	public T getById(int id) {
		// TODO
		return null;
	}

}
