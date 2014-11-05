import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JMSProducerTest {

    public static void main(String[] args) throws NamingException, IOException, InterruptedException, JMSException {
        Context context = getNamingContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
        Destination queueDestination = (Destination) context.lookup("jms/myqueues/TestQueue");
        Destination topicDestination = (Destination) context.lookup("jms/mytopics/TestTopic");

        try (JMSContext jmsContext = connectionFactory.createContext("appuser", "appuser12345")) {
            JMSProducer jmsProducer = jmsContext.createProducer();
            int counter = 1;
            while(true) {
                TextMessage textMessage = jmsContext.createTextMessage(counter + ": BYE!");
                textMessage.setIntProperty("rem", counter % 4);
                jmsProducer.send(queueDestination, textMessage);
                jmsProducer.send(topicDestination, textMessage);
                Thread.sleep(1000);
                counter++;
            }
        }
    }

    public static Context getNamingContext() throws NamingException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("test.properties"));
        return new InitialContext(properties);
    }
}
