package cdi;

import co.karans.supermarket.services.api.ProductServiceClient;

import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class ClientProducer {

    @Produces
    public ProductServiceClient produce() {
        try {
            Properties properties = new Properties();
            // properties.put("java.naming.factory.initial", "org.apache.openejb.client.RemoteInitialContextFactory");
            // properties.put("java.naming.provider.url", "http://localhost:8080/tomee/ejb");

            properties.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
            properties.put("java.naming.provider.url", "remote://localhost:4447");
            return (ProductServiceClient) new InitialContext(properties).lookup("java:global/super-market/product-services/ProductEJB");
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
