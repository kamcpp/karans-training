package co.karans.session27.ejbs.impl.cdi;

import co.karans.session27.servicescalc.CalcService;

import javax.enterprise.inject.Produces;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class Producers {

    @Produces
    public CalcService getCalcService() {
        try {
            URL url = new URL("http://10.10.103.19:8080/calculation-service/CalcService?wsdl");
            QName qName = new QName("http://servicescalc.session27.karans.co/", "CalcServiceService");
            Service service = Service.create(url, qName);
            CalcService calcService = service.getPort(CalcService.class);
            return calcService;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
