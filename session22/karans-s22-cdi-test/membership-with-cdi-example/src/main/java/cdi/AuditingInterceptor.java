package cdi;

import domain.AuditDao;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Auditable
@Interceptor
public class AuditingInterceptor {

    @Inject
    private AuditDao auditDao;

    @AroundInvoke
    public Object auditMethod(InvocationContext ic) throws Exception {
        try {
            auditDao.add("Before calling " + ic.getMethod().getName());
            Object obj = ic.proceed();
            auditDao.add(ic.getMethod().getName() + " has been finished.");
            return obj;
        } catch (Exception e) {
            auditDao.add(ic.getMethod().getName() + " has been finished with exceptions: " + e.getMessage());
            throw e;
        }
    }
}
