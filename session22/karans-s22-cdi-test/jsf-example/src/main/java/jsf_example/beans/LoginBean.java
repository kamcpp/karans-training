package jsf_example.beans;

import jsf_example.injection.AuthenticationService;
import jsf_example.injection.UsernamePasswordCredential;
import jsf_example.injection.UsernamePasswordService;
import jsf_example.interceptors.Loggable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;
    private String password;

    @Inject
    private int age;
    @Inject
    private String myName;
    @Inject
    private Connection connection;

    public LoginBean() {
        System.out.println("Login Bean is created.");
    }

    @Inject
    @UsernamePasswordService
    private AuthenticationService authenticationService;

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

    public String authenticate() {
        System.out.println("My name is " + myName + ". I have " + age + " years old.");
        if(authenticationService.authenticate(new UsernamePasswordCredential(username, password))) {
            return "home";
        } else {
            return "login";
        }
    }
}
