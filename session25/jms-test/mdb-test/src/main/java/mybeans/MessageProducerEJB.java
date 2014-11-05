package mybeans;

import mdb_test.api.MessageProducerLocal;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Stateless
@LocalBean
@Local(MessageProducerLocal.class)
public class MessageProducerEJB implements MessageProducerLocal {

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "java:/jms/myqueues/TestQueue")
    private Destination destination;

    @Resource
    private SessionContext sessionContext;

    @Override
    public void sendMessage(String text) {

        try {
            Scanner scanner = new Scanner(new FileInputStream("/test.properties"));
            System.out.println(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JMSProducer producer = jmsContext.createProducer();
        producer.send(destination, text);
    }
}
