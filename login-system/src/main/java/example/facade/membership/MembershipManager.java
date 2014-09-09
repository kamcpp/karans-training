package example.facade.membership;

import java.util.List;

import example.domain.entity.User;

public interface MembershipManager {

	void addUser(User user);

	User getUserByUsername(String username);

	boolean userExists(String username);

	List<User> getUsers();

	void activateUser(String username);

	void diableUser(String username);
}
