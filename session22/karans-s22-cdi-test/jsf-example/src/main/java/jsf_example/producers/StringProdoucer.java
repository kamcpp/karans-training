package jsf_example.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;

@ApplicationScoped
public class StringProdoucer implements Serializable {
    private int age = 20;

    public StringProdoucer() {
        System.out.println("HOOOORAAAAAYYYYY");
    }

    @Produces
    public String f() {
        return "JOHN";
    }
    @Produces
    public int age() {
        return age++;
    }
}
