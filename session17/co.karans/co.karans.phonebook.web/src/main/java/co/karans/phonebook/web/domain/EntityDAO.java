package co.karans.phonebook.web.domain;

import java.util.List;

public interface EntityDAO<T> {

	void save(T entity);

	void delete(T entity);

	List<T> getAll();

	T getById(int id);
}
