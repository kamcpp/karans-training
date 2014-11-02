package biz;

import java.util.UUID;

public interface Membership {

    void createUser(String name, String username, String password);

    UUID findByeUsernameAndPassword(String username, String password);
}
