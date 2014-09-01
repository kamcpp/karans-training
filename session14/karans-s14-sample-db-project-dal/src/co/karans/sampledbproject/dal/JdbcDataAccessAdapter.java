package co.karans.sampledbproject.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class JdbcDataAccessAdapter implements DataAccessAdapter {

	@Autowired
	private DataSource ds;

	@Override
	public DataAccessAdapterResult submitCommand(
			DataAccessAdapterCommand command) throws DataAccessException {
		try {
			try (Connection connection = ds.getConnection();
					PreparedStatement statement = connection
							.prepareStatement(((DefaultDataAccessAdapterCommand) command)
									.getCommand());) {
				int counter = 1;
				for (Object o : ((DefaultDataAccessAdapterCommand) command)
						.getParameters()) {
					statement.setObject(counter, o);
					counter++;
				}
				statement.execute();
				return null;
			}
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}
}
