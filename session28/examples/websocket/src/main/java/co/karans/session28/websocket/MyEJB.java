package co.karans.session28.websocket;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.websocket.Session;
import java.util.Date;

@Stateless
public class MyEJB {
    public static Session session;

    @Schedule(hour="*", minute="*", second = "0/5")
    public void sendDate() {
        if(session != null) {
            session.getAsyncRemote().sendText(new Date().toString());
        }
    }
}
