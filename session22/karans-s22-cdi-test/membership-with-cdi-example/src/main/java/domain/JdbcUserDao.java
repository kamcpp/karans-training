package domain;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.UUID;

@ApplicationScoped
public class JdbcUserDao  implements UserDao {

    @Inject
    private Connection connection;

    @Override
    public UUID addUser(User user) {
        try {
<<<<<<< Updated upstream:session22/karans-s22-cdi-test/membership-with-cdi-example/src/main/java/domain/JdbcUserDao.java
            PreparedStatement ps = connection.prepareStatement("INSERT INTO myuser VALUES (?, ?, ?, ?)");
            ps.setObject(1, user.getId().toString(), Types.OTHER);
=======
            PreparedStatement ps = connection.prepareStatement("INSERT INTO myuser (id, name, username, password) VALUES (?, ?, ?, ?)");
            ps.setObject(1, user.getId().toString(), Types.OTHER);
            System.out.println("===> " + user.getName());
>>>>>>> Stashed changes:karans-s22-cdi-test/membership-with-cdi-example/src/main/java/domain/JdbcUserDao.java
            ps.setString(2, user.getName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.execute();
            return user.getId();
        } catch( Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM myuser WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            User user = new User();
            user.setId(UUID.fromString(rs.getString("id")));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        } catch( Exception e) {
            throw new RuntimeException(e);
        }
    }
}
