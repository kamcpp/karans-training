package co.karans.session27.websockets;

import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.websocket.Session;
import java.util.Date;

@Stateless
@LocalBean
public class TalkerEJB {
    public static Session session;

    @Schedule(hour = "*", minute = "*", second = "0/5")
    public void talk() {
        if (session != null) {
            session.getAsyncRemote().sendText(new Date().toString());
        }
    }
}
