package co.karans.session28.server.websocket;

import co.karans.session28.server.repo.SessionRepository;

import javax.inject.Inject;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collection;
import java.util.List;

@ServerEndpoint("/chat")
public class ChatEndpoint {

    @Inject
    private SessionRepository sessionRepository;

    @OnMessage
    public void processMessage(String text, Session session) {
        System.out.println("Received: " + text);
        ChatMessage chatMessage = parseReceivedText(text);
        if (chatMessage.getCommand() == ChatCommand.REGISTER) {
            System.out.println("This is a REGISTER command.");
            registerUser(chatMessage.getValue(), session);
        } else if (chatMessage.getCommand() == ChatCommand.MESSAGE_BROADCAST) {
            System.out.println("This is a BROADCAST command.");
            broadcastMessage(session, chatMessage.getValue());
        }
    }

    private ChatMessage parseReceivedText(String text) {
        String[] textparts = text.split(":", 2);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setCommand(ChatCommand.convertFromString(textparts[0]));
        chatMessage.setValue(textparts[1]);
        return chatMessage;
    }

    private void registerUser(String username, Session session) {
        sessionRepository.addNewSession(username, session);
    }

    private void broadcastMessage(Session session, String message) {
        System.out.println("We are inside of boradcastMessage(...) ...");
        Collection<Session> allSessions = sessionRepository.getAllSessions();
        System.out.println("Sending to all sessions: " + allSessions.size());
        for (Session s : allSessions) {
            try {
                s.getAsyncRemote().sendText("MRC:" + sessionRepository.getUsername(session) + ":" + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
