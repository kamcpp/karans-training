package co.karans.sampledbproject.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcDataAccessAdapter implements DataAccessAdapter {

	@Override
	public DataAccessAdapterResult submitCommand(
			DataAccessAdapterCommand command) throws DataAccessException {
		try {
			Class.forName("org.postgresql.Driver");
			try (Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://10.10.103.48:5433/mydb", "myuser",
					"12345");
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
