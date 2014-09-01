package co.karans.sampledbproject.dal;

public interface DataAccessAdapter {

	DataAccessAdapterResult submitCommand(DataAccessAdapterCommand command)
			throws DataAccessException;
}
