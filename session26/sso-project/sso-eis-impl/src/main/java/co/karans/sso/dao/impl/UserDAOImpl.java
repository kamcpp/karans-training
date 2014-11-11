package co.karans.sso.dao.impl;

import co.karans.sso.dao.UserDAO;
import co.karans.sso.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "sso")
    private EntityManager entityManager;

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
