package co.karans.session28.server.websocket;

public enum ChatCommand {
    REGISTER,
    MESSAGE_P2P,
    MESSAGE_BROADCAST,
    MESSAGE_RECIEVED,
    LOGOUT,
    UNKNOWN;

    public static ChatCommand convertFromString(String command) {
        if (command.equals("REG")) {
            return ChatCommand.REGISTER;
        } else if (command.equals("P2P")) {
            return ChatCommand.MESSAGE_P2P;
        } else if (command.equals("MBC")) {
            return ChatCommand.MESSAGE_BROADCAST;
        } else if (command.equals("MRC")) {
            return ChatCommand.MESSAGE_RECIEVED;
        } else if (command.equals("BYE")) {
            return ChatCommand.LOGOUT;
        } else {
            return ChatCommand.UNKNOWN;
        }
    }
}
