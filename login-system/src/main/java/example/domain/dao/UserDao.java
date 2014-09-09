package example.domain.dao;

import java.util.List;

import example.domain.entity.User;

public interface UserDao {
	void save(User user);
	
	void delete(User user);
	

	
	List<User> getAllUser();
	
	User getUserByUsername(String username);


}
