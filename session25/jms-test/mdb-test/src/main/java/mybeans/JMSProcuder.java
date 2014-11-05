package mybeans;

import javax.enterprise.inject.Produces;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JMSProcuder {

    public JMSContext createWildflyJMSContext() throws IOException, NamingException {
        return ((ConnectionFactory)getNamingContext().lookup("jms/RemoteConnectionFactory")).createContext("appuser", "appuser12345");
    }

    public Context getNamingContext() throws NamingException, IOException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
        properties.put(Context.SECURITY_PRINCIPAL, "appuser");
        properties.put(Context.SECURITY_CREDENTIALS, "appuser12345");
        return new InitialContext(properties);
    }
}
