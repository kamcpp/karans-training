package tess;

public enum ChatCommand {
    REGISTER("REG"),
    MESSAGE_P2P("MP2P"),
    MESSAGE_BROADCAST("MBR"),
    LOGOUT("BYE");

    private String command;

    public String getCommand() {
        return command;
    }

    private ChatCommand(String command) {
        this.command = command;
    }

    public static ChatCommand convert(String str) {
        return ChatCommand.LOGOUT;
    }
}
