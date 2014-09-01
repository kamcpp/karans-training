package co.karans.sampledbproject.dal;

public class DataAccessAdapterFactory {

	private volatile static DataAccessAdapter adapter;

	public static DataAccessAdapter getDefaultAdapter() {
		DataAccessAdapter result = adapter;
		if (result == null) {
			synchronized (DataAccessAdapterFactory.class) {
				result = adapter;
				if (result == null) {
					adapter = result = new JdbcDataAccessAdapter();
				}
			}
		}
		return result;
	}
}
