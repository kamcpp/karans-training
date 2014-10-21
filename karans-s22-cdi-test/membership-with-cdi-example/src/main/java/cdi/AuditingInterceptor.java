package cdi;

import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Auditable
@Interceptor
public class AuditingInterceptor {
    public Object auditMethod(InvocationContext ic) throws Exception {
        // TODO
        try {
            Object obj = ic.proceed();
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }
}
