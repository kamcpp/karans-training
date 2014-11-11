package co.karans.sso.eis.co.karans.sso.eis;

import co.karans.sso.dao.TokenDAO;
import co.karans.sso.dao.UserDAO;
import co.karans.sso.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
@Local(UserDAO.class)
public class FakeUserDAO implements UserDAO {
    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public long saveOrUpdate(User user) {
        return 0;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(long id) {
        return null;
    }
}
