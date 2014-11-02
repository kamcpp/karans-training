package ejb;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import javax.inject.Inject;
import java.io.Serializable;

@Stateful
@LocalBean
public class CounterEJB implements Serializable {

    private int counter;

    public CounterEJB() {
        counter = 0;
        System.out.println("CTOR: Counter EJB has been made.");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("POST CONSTRUCT");
    }

    @PreDestroy
    public void postDestroy() {
        System.out.println("PRE DESTROY");
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("PRE PASSIVATE");
    }

    @PostActivate
    public void postActivate() {
        System.out.println("POST ACTIVATE");
    }

    public void increase() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
