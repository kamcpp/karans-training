package cdi2;

import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class LoggerProducer {
    @Produces
    private Logger getLogger(InjectionPoint injectionPoint) {
        System.out.println("---> Getting logger for " + injectionPoint.getMember().getDeclaringClass().getName());
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass());
    }
}
