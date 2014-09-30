package ejb_test_2;

import ejb_test_2.api.HelloWorldBeanRemote;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name="myHelloWorldObject")
public class HelloWorldEJB implements HelloWorldBeanRemote {
    public String sayHello(String name) {
        return "Hello " + name + " from Karans over EJB";
    }
}
