package cdi;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionProducer {

    @Produces
    public Connection makeConnection() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String jdbcUri = "jdbc:postgresql://10.10.103.17:5432/karans22db";
            return DriverManager.getConnection(jdbcUri, "karansuser", "eshoppass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void closeConnection(@Disposes Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
        }
    }
}
