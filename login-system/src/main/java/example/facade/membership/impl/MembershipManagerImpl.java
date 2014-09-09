package example.facade.membership.impl;

import java.util.List;

import example.common.crypto.Crypto;
import example.common.spring.SpringContext;
import example.domain.dao.UserDao;
import example.domain.entity.User;
import example.facade.membership.FacadeUser;
import example.facade.membership.MembershipManager;

public class MembershipManagerImpl implements MembershipManager {

	public static UserDao userDao;

	@Override
	public void addUser(FacadeUser user) {
		User userEntity = new User();
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
		User userEntity = new User();
		userEntity = userDao.getUserByUsername(username);
		if (userEntity != null) {
			FacadeUser facadUser = new FacadeUser();
			facadUser.setEmail(userEntity.getEmail());
			facadUser.setName(userEntity.getName());
			facadUser.setFamily(userEntity.getFamily());
			facadUser.setUsername(userEntity.getUsername());
			facadUser.setPassword(userEntity.getHashedPassword());
			return facadUser;
		}
		return null;
	}

	@Override
	public boolean userExists(String username) {
		User userEntity = new User();
		userEntity = userDao.getUserByUsername(username);
		if (userEntity == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<FacadeUser> getUsers() {
		List<User> users = userDao.getAllUser();
		List<FacadeUser> facadUsers;
		FacadeUser facadUser = new FacadeUser();
		for (User user : users) {
			// TODO
		}
		return null;
	}

	@Override
	public void activateUser(String username) {
		changeActiveStatus(username, true);
	}

	@Override
	public void diableUser(String username) {
		changeActiveStatus(username, false);
	}

	private void changeActiveStatus(String username, boolean active) {
		User userEntity = userDao.getUserByUsername(username);
		if (userEntity != null) {
			userEntity.setActive(active);
			userDao.save(userEntity);
		}
	}

	@Override
	public boolean authenticate(FacadeUser user) {
		User userEntity = userDao.getUserByUsername(user.getUsername());
		if (userEntity == null) {
			return false;
		}
		return userEntity.isActive()
				&& userEntity.getHashedPassword().equals(
						Crypto.getHashProviderFactory().getHashProvider()
								.hash(user.getPassword()));
	}
}
