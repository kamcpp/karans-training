import rmi_test.api.HelloWorld;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Properties;

public class JndiClient {
    public static void main(String[] args) throws NamingException, RemoteException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        properties.put(Context.PROVIDER_URL, "rmi://10.10.103.29:1099");
        Context context = new InitialContext(properties);
        HelloWorld remoteObject = (HelloWorld)context.lookup("myHelloWorldObject");
        System.out.println(remoteObject.getCounter());
    }
}
