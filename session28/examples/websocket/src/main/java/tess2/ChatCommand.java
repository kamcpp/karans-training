package tess2;


public class ChatCommand {

    public static final ChatCommand REGISTER = new ChatCommand("REG");
    public static final ChatCommand MESSAGE_P2P = new ChatCommand("MP2P");
    public static final ChatCommand MESSAGE_BROADCAST = new ChatCommand("MBC");
    public static final ChatCommand LOGOUT = new ChatCommand("BYE");

    private String command;

    public ChatCommand(String command ) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
