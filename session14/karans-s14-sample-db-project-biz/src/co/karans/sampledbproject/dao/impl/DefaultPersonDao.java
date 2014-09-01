package co.karans.sampledbproject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import co.karans.sampledbproject.dal.DataAccessAdapter;
import co.karans.sampledbproject.dal.DataAccessAdapterFactory;
import co.karans.sampledbproject.dal.DataAccessException;
import co.karans.sampledbproject.dal.DefaultDataAccessAdapterCommand;
import co.karans.sampledbproject.dao.PersonDao;
import co.karans.sampledbproject.domain.Person;

public class DefaultPersonDao implements PersonDao {

	private DataAccessAdapter adapter = DataAccessAdapterFactory
			.getDefaultAdapter();

	@Override
	public void insert(Person p) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(p.getId());
		parameters.add(p.getName());
		DefaultDataAccessAdapterCommand command = new DefaultDataAccessAdapterCommand(
				"INSERT INTO person VALUES (?, ?)", parameters);
		try {
			adapter.submitCommand(command);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
