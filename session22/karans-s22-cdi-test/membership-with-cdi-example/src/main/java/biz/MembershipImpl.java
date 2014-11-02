package biz;

import cdi.Auditable;
import cdi2.LoggingInterceptor;
import cdi2.Secure;
import domain.User;
import domain.UserDao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import java.util.UUID;

@Secure
@Auditable
@ApplicationScoped
public class MembershipImpl implements Membership {

    @Inject
    private UserDao userDao;

    @Override
    @Interceptors(LoggingInterceptor.class)
    public void createUser(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setId(UUID.randomUUID());
        userDao.addUser(user);
    }

    @Override
    public UUID findByeUsernameAndPassword(String username, String password) {
        User user = userDao.findUserByUsernameAndPassword(username, password);
        return user.getId();
    }

    @AroundInvoke
    public Object performAuditing(InvocationContext invocationContext) throws Exception {
        System.out.println("AUDIT SYSTEM: We are going to invoke a method: " + invocationContext.getMethod().getName() + " ...");
        Object object = invocationContext.proceed();
        System.out.println("AUDIT SYSTEM: The method has been invoked.");
        return object;
    }
}
