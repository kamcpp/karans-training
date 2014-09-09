package example.domain.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import example.domain.dao.UserDao;
import example.domain.entity.User;

public class UserDaoImpl implements UserDao {
	protected static EntityManager entityManager;

	static {
		entityManager = Persistence.createEntityManagerFactory("user")
				.createEntityManager();
	}

	@Override
	public void save(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		System.out.println("data is added");
	}

	@Override
	public void delete(User user) {
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		System.out.println("Data is removed.");
	}

	@Override
	public List<User> getAllUser() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object> query = cb.createQuery();
		return (List) entityManager.createQuery(query).getResultList();
	}

	@Override
	public User getUserByUsername(String username) {
		return null;
	}
}
