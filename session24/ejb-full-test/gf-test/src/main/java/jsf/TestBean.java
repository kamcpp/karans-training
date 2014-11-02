package jsf;

import ejb.CounterEJB;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TestBean {

    @EJB
    private CounterEJB counterEJB;

    public int getCounter() {
        counterEJB.increase();
        return counterEJB.getCounter();
    }
}
