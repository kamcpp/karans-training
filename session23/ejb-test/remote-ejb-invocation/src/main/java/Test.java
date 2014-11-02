import my_ejb_api.MyNumberGeneratorLocal;
import my_ejb_api.MyNumberGeneratorRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws NamingException {
        Properties p = new Properties();
        p.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
        p.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");

        InitialContext ctx = new InitialContext(p);

        MyNumberGeneratorRemote myNumberGeneratorRemote = (MyNumberGeneratorRemote) ctx.lookup("RandomNumberGeneratorRemote");
        System.out.println(myNumberGeneratorRemote.generateNumber());
    }
}
