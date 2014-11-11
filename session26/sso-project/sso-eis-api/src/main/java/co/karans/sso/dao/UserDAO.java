package co.karans.sso.dao;

import co.karans.sso.entity.User;

public interface UserDAO extends GenericDAO<User> {

    User getByUsername(String username);

    User getByEmail(String email);

    User getByUsernameAndPassword(String username, String password);
}
