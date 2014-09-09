package example.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import example.common.spring.SpringContext;
import example.domain.dao.UserDao;
import example.facade.membership.impl.MembershipManagerImpl;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out
				.println(".........................................................................");
		UserDao userDao = (UserDao) SpringContext.getContext().getBean(
				UserDao.class);
		MembershipManagerImpl.userDao = userDao;
	}
}
