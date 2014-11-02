package cdi;

import org.apache.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class Log4jProducer {

    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(Log4jProducer.class);
    }
}
