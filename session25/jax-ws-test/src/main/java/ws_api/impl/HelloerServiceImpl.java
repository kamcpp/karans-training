package ws_api.impl;

import ws_api.HelloerService;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "Helloer", endpointInterface = "ws_api.HelloerService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class HelloerServiceImpl implements HelloerService {
    @Override
    public String sayHello(String name, String family) {
        return "Hello " + name + " " + family + "!";
    }
}
