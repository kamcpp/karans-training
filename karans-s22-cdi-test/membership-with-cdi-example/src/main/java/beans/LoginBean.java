package beans;

import biz.Membership;
import utils.HashProvider;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

@Named
@ManagedBean
public class LoginBean {

    private String username;
    private String password;

    @Inject
    private Membership membership;
    @Inject
    private HashProvider hashProvider;

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

    public String doLogin() {
        try {
            UUID id = membership.findByeUsernameAndPassword(username, hashProvider.hash(password));
            return "home";
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }
}
