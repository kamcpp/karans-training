package co.karans.session27.client;

import co.karans.session27.services.FirstService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://ubuntu:8080/services-impl/FirstServiceImpl?wsdl");
        QName qName = new QName("http://impl.services.session27.karans.co/", "FirstServiceImplService");
        Service service = Service.create(url, qName);
        FirstService firstService = service.getPort(FirstService.class);
        double result = firstService.calculate(45,89);
        System.out.println(result);
    }
}
