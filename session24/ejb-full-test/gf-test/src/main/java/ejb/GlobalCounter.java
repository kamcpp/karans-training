package ejb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@Local(GlobalCounterInterface.class)
public class GlobalCounter implements GlobalCounterInterface {

    private int c;

    public GlobalCounter() {
        System.out.println("SINGLETON MAAADE: " + getClass());
    }

    public void increase() {
        c++;
    }

    public int getC() {
        return c;
    }
}
