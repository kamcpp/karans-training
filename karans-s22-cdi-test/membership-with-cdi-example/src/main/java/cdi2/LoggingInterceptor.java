package cdi2;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;


public class LoggingInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object performLogging(InvocationContext invocationContext) throws Exception {
        logger.trace("LOGGING SYSTEM: We are going to invoke a method: " + invocationContext.getMethod().getName() + " ...");
        try {
            Object object = invocationContext.proceed();
            logger.trace("LOGGING SYSTEM: The method has been invoked.");
            return object;
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }
}
