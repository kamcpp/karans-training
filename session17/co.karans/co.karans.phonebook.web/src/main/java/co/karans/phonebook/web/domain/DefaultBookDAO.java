package co.karans.phonebook.web.domain;

import java.util.List;

public class DefaultBookDAO extends DefaultEntityDAO<Book> implements BookDAO {

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> getAll() {
		return entityManager.createQuery("from Book").getResultList();
	}
}
