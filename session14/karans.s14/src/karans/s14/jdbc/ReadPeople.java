package karans.s14.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPeople {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		Class.forName("org.postgresql.Driver");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://10.10.103.48:5433/mydb", "myuser", "12345");
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM person;");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in))) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println("-----");
			}
		}
	}
}
