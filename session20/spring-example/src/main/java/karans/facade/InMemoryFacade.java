package karans.facade;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFacade implements Facade {

    private List<User> users = new ArrayList<User>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User getUserByUsername(String username) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
