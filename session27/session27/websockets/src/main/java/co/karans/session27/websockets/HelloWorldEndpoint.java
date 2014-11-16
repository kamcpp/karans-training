package co.karans.session27.websockets;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hw")
public class HelloWorldEndpoint {

    @OnMessage
    public void helloWorld(String text, Session clientSession) {
        TalkerEJB.session = clientSession;
        clientSession.getAsyncRemote().sendText("HELLO WORLD " + text);
    }
}
