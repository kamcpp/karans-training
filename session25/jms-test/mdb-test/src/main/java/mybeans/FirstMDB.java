package mybeans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/myqueues/TestQueue"))
public class FirstMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("MDB received a message: " + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
