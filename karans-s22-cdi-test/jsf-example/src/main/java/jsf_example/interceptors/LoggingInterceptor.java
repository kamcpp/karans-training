package jsf_example.interceptors;


import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Loggable
@Interceptor
public class LoggingInterceptor {
    @AroundInvoke
    public Object log(InvocationContext invocationContext) throws Exception {
        System.out.println("Before invocation ...");
        Object obj = invocationContext.proceed();
        System.out.println("After invocation ...");
        return obj;
    }
}
