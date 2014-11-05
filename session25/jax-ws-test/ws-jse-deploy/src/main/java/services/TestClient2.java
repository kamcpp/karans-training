package services;

import ws_api.HelloerService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class TestClient2 {
    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/jax-ws-test/HelloerServiceImplService?wsdl");

        QName qname = new QName("http://impl.ws_api/", "HelloerServiceImplService");

        Service service = Service.create(url, qname);

        HelloerService helloerService = service.getPort(HelloerService.class);

        String result = helloerService.sayHello("John", "Alex");

        System.out.println(result);
    }
}
