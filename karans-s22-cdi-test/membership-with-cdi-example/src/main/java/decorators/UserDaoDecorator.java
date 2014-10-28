package decorators;

import domain.User;
import domain.UserDao;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.UUID;

@Decorator
public class UserDaoDecorator implements UserDao {

    @Inject
    @Delegate
    private UserDao userDao;

    @Override
    public UUID addUser(User user) {
        user.setUsername(user.getUsername() + "_USER");
        return userDao.addUser(user);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        return userDao.findUserByUsernameAndPassword(username, password);
    }
}
