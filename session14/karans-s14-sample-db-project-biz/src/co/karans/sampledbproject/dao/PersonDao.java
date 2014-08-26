package co.karans.sampledbproject.dao;

import java.util.List;

import co.karans.sampledbproject.domain.Person;

public interface PersonDao {

	void insert(Person p);

	void update(Person p);

	void delete(Person p);

	List<Person> getAll();

	Person getByName(String name);
}
