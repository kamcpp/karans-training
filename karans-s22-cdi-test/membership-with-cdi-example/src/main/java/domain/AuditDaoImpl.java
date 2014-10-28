package domain;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.UUID;

public class AuditDaoImpl implements AuditDao {

    @Inject
    private Connection connection;

    @Override
    public void add(String description) {
        add(UUID.randomUUID(), description, new Date());
    }

    @Override
    public void add(UUID id, String description, Date date) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AUDIT VALUES (?, ?, ?)");
            preparedStatement.setObject(1, id, Types.OTHER);
            preparedStatement.setLong(2, date.getTime());
            preparedStatement.setString(3, description);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
