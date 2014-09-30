package ejb_test_2.api;

import javax.ejb.Remote;

@Remote
public interface HelloWorldBeanRemote {
    String sayHello(String name);
}
