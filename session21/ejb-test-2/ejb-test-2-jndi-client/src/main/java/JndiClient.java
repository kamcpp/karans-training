import ejb_test_2.api.HelloWorldBeanRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JndiClient {
    public static void main(String[] args) throws NamingException {
        InitialContext context = new InitialContext();
        HelloWorldBeanRemote remoteObject = (HelloWorldBeanRemote) context.lookup("myHelloWorldObjectRemote");
        System.out.println(remoteObject.sayHello("MEEEE"));
    }
}
