package ejb_test.method1;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldEJB {
    public String sayHello() {
        return "Hello World!";
    }
}
