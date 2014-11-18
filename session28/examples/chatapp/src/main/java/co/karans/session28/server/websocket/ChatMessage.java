package co.karans.session28.server.websocket;

public class ChatMessage {
    private ChatCommand command;
    private String value;

    public ChatCommand getCommand() {
        return command;
    }

    public void setCommand(ChatCommand command) {
        this.command = command;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
