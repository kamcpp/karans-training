package karans.facade;

public interface Facade {

    void addUser(User user);

    User getUserByUsername(String username);
}
