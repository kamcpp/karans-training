import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JMSConsumerTest {
    public static void main(String[] args) throws NamingException, JMSException, IOException {
        Context context = getNamingContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        Destination destination = (Destination) context.lookup("jms/myqueues/TestQueue");

        try (JMSContext jmsContext = connectionFactory.createContext("appuser", "appuser12345")) {
            JMSConsumer jmsConsumer = jmsContext.createConsumer(destination);
            System.out.println(jmsConsumer.getClass());
            Message message;

            while((message = jmsConsumer.receiveNoWait()) != null) {
                System.out.println(message.getBody(String.class));
            }
        }
    }

    public static Context getNamingContext() throws NamingException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test.properties"));
        return new InitialContext(properties);
    }
}
