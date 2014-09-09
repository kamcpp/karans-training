package example.facade.membership.impl;

import java.util.List;

import example.common.crypto.Crypto;
import example.domain.dao.UserDao;
import example.domain.entity.User;
import example.facade.membership.FacadeUser;
import example.facade.membership.MembershipManager;

public class MembershipManagerImpl implements MembershipManager {

	UserDao userDao;

		@Override
	public void addUser(FacadeUser user) {  
		User userEntity=new User();
		userEntity.setName(user.getName());
		userEntity.setFamily(user.getFamily());
		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setHashedPassword(Crypto.getHashProviderFactory()
				.getHashProvider().hash(user.getPassword()));
		userDao.save(userEntity);
	}

	@Override
	public FacadeUser getUserByUsername(String username) {
		User userEntity=new User();
		userEntity = userDao.getUserByUsername(username);
		FacadeUser facadUser = new FacadeUser();
		if (userEntity != null) {
			facadUser.setEmail(userEntity.getEmail());
			facadUser.setName(userEntity.getName());
			facadUser.setFamily(userEntity.getFamily());
			facadUser.setUsername(userEntity.getUsername());
			facadUser.setPassword(userEntity.getHashedPassword());
		}
		return facadUser;
	}

	@Override
	public boolean userExists(String username) {
		User userEntity=new User();
		userEntity = userDao.getUserByUsername(username);
		if (userEntity.isActive())
			return true;
		else
			return false;
	}

	@Override
	public List<FacadeUser> getUsers() {
		List<User> users = userDao.getAllUser();
		List<FacadeUser> facadUsers ;
		FacadeUser facadUser=new FacadeUser();
		for (User user : users) {
			

		}
		return null;
	}

	@Override
	public void activateUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void diableUser(String username) {
		// TODO Auto-generated method stub

	}
}
