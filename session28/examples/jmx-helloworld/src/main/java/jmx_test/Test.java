package jmx_test;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Test {
    public static void main(String[] args) throws MalformedObjectNameException,
            NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        Hello helloMBean = Hello.getInstance();
        ObjectName objectName = new ObjectName("jmx_test:type=Hello");
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        server.registerMBean(helloMBean, objectName);
        while (true) {
            if (helloMBean.isChecked()) {
                System.out.println("This is great!");
            } else {
                System.out.println("This is BAD!");
            }
            Thread.sleep(1000);
        }
    }
}
