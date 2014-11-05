import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AsyncJMSConsumerTest {
    public static void main(String[] args) throws NamingException, JMSException, IOException {
        Context context = getNamingContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        Destination destination = (Destination) context.lookup("jms/myqueues/TestQueue");

        try (JMSContext jmsContext = connectionFactory.createContext("appuser", "appuser12345")) {
            JMSConsumer jmsConsumer = jmsContext.createConsumer(destination, "rem = 0");
            System.out.println(jmsConsumer.getClass());

            MessageListener messageListener = new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(Thread.currentThread().getName() + ": " + message.getBody(String.class) + ", rem: " + message.getIntProperty("rem"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            };

            jmsConsumer.setMessageListener(messageListener);
            while (true) ;
        }
    }

    public static Context getNamingContext() throws NamingException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test.properties"));
        return new InitialContext(properties);
    }
}
