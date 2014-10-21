package domain;

import java.util.UUID;

public interface UserDao {

    UUID addUser(User user);

    User findUserByUsernameAndPassword(String username, String password);
}
