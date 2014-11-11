package co.karans.sso.ws.api;

import java.util.UUID;

public class Token {
    String value;

    public Token() {
        value = UUID.randomUUID().toString() + UUID.randomUUID().toString();
    }

    public Token(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
