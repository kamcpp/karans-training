package ws_api;

import javax.jws.WebService;

@WebService
public interface HelloerService {
    String sayHello(String name, String family);
}
