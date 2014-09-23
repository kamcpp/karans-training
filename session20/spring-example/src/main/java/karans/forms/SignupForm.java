package karans.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupForm {

    @NotNull
    private String name;
    @NotNull
    @Size(min=5, max=20)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String passwordConfirmation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
