package karans.s14.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleConnection {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver is loaded.");
		Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://10.10.103.48:5433/mydb", "myuser", "12345");
		System.out.println("Connection is created.");
		PreparedStatement statement = connection.prepareStatement("INSERT INTO person VALUES (?, ?);");
		statement.setInt(1, 569);
		statement.setString(2, "sdkjfjksdfh");
		statement.execute();
		System.out.println("Statement executed.");
		connection.close();
		System.out.println("Connection closed.");
	}
}
