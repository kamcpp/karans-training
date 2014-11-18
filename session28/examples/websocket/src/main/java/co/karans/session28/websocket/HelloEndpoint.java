package co.karans.session28.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class HelloEndpoint {

    public HelloEndpoint() {
        System.out.println("HELLO WORLD HAS BEEN MADE.");
    }

    @OnMessage
    public void messageReceived(String text, Session clientSession) {
        System.out.println("====> " + clientSession.getId());
        MyEJB.session = clientSession;
        clientSession.getAsyncRemote().sendText("Hello " + text);
    }

    @OnOpen
    public void open(Session session) {
        System.out.println("Session openned: " + session.getId());
    }

    @OnClose
    public void close(Session session, CloseReason closeReason) {
        System.out.println("Session closed: " + closeReason.getReasonPhrase());
    }
}
