package beans;

import biz.Membership;
import utils.HashProvider;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ManagedBean
public class SignupBean {

    private String name;
    private String username;
    private String password;

    @Inject
    private Membership membership;
    @Inject
    private HashProvider hashProvider;

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

    public String doSignup() {
        try {
            membership.createUser(name, username, hashProvider.hash(password));
            return "login";
        } catch( Exception e ) {
            e.printStackTrace();
            return "signup";
        }
    }
}
