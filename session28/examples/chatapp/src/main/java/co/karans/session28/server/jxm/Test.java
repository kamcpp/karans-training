package co.karans.session28.server.jxm;

import javax.annotation.ManagedBean;
import javax.ejb.Singleton;

public class Test implements TestMBean {

    private int counter;

    @Override
    public int getCounter() {
        return counter;
    }

    @Override
    public void setCounter(int counter) {
        this.counter = counter;
    }
}
