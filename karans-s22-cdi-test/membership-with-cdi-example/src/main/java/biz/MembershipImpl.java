package biz;

import cdi.Auditable;
import domain.User;
import domain.UserDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@Auditable
@ApplicationScoped
public class MembershipImpl implements Membership {

    @Inject
    private UserDao userDao;

    @Override
    public void createUser(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setId(UUID.randomUUID());
        userDao.addUser(user);
    }

    @Override
    public UUID findByeUsernameAndPassword(String username, String password) {
        User user = userDao.findUserByUsernameAndPassword(username, password);
        return user.getId();
    }
}
