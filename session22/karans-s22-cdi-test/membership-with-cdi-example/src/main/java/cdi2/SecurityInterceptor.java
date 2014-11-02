package cdi2;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Secure
@Interceptor
public class SecurityInterceptor {

    @AroundConstruct
    public void construct(InvocationContext invocationContext) throws Exception {
        System.out.println("SECURITY SYSTEM: CONSTRUCTION .....");
        invocationContext.proceed();
        System.out.println("SECURITY SYSTEM: CONSTRUCTED.");
    }

    @AroundInvoke
    public Object secure(InvocationContext invocationContext) throws Exception {
        System.out.println("SECURITY SYSTEM: We are going to invoke a method: " + invocationContext.getMethod().getName() + " ...");
        Object object = invocationContext.proceed();
        System.out.println("SECURITY SYSTEM: The method has been invoked.");
        return object;
    }
}
