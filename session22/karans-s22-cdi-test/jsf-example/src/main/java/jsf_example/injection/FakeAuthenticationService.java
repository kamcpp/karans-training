package jsf_example.injection;


import jsf_example.interceptors.Loggable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@UsernamePasswordService
@ApplicationScoped
public class FakeAuthenticationService implements AuthenticationService {

    @PostConstruct
    public void f() {
        System.out.println("Acitvating auth. service ...");
    }

    @PreDestroy
    public void g() {
        System.out.println("Passivation or destruction of auth. service ...");
    }

    @Override
    @Loggable
    public boolean authenticate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            return ((UsernamePasswordCredential) credential).getUsername().equals("admin") && ((UsernamePasswordCredential) credential).getPassword().equals("12345");
        }
        throw new IllegalArgumentException();
    }
}
