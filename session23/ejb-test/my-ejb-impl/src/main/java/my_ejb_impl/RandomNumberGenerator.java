package my_ejb_impl;


import my_ejb_api.MyNumberGeneratorLocal;
import my_ejb_api.MyNumberGeneratorRemote;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.Random;

@Stateless
@Remote(MyNumberGeneratorRemote.class)
@Local(MyNumberGeneratorLocal.class)
@LocalBean
public class RandomNumberGenerator implements MyNumberGeneratorLocal, MyNumberGeneratorRemote {
    public RandomNumberGenerator() {
        System.out.println("CTOR: EJB Created.");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("EJB has been created.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("EJB is about to be destroyed.");
    }

    @Override
    public String generateNumber() {
        return "" + new Random().nextInt(Integer.MAX_VALUE);
    }

    @Override
    public String generateYourNumber() {
        return "RANDOM_" + generateNumber();
    }
}
