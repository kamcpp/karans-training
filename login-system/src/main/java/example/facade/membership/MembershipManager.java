package example.facade.membership;

import java.util.List;

public interface MembershipManager {

	void addUser(FacadeUser user);

	FacadeUser getUserByUsername(String username);

	boolean userExists(String username);

	List<FacadeUser> getUsers();

	void activateUser(String username);

	void diableUser(String username);

	boolean authenticate(FacadeUser user);
}
