package karans.s14.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimpleSQLInjectionAttack {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException, NumberFormatException, IOException {
		Class.forName("org.postgresql.Driver");
		try (Connection connection = DriverManager.getConnection(
				"jdbc:postgresql://10.10.103.48:5433/mydb", "myuser", "12345");
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO person VALUES (?, ?);");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in))) {
			System.out.print("Enter id? ");
			statement.setInt(1, Integer.parseInt(reader.readLine()));
			System.out.print("Enter name? ");
			statement.setString(2, reader.readLine());
			statement.execute();
			System.out.println("Statement executed.");
		}
	}
}
