package rmi_test.api;

import java.io.Serializable;

public class HelloMessage implements Serializable {

    private String message;

    public HelloMessage(String message) {
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
