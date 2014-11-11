package co.karans.sso.entity;

import javax.persistence.*;

@Entity
@Table(name = "sso_user", schema = "sso")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="active", nullable = false)
    private boolean active;
    @Column(name="name", length = 256, nullable = false)
    private String name;
    @Column(name="family", length = 256, nullable = false)
    private String family;
    @Column(name="username", length = 256, nullable = false)
    private String username;
    @Column(name="password", length = 256, nullable = false)
    private String password;
    @Column(name="email", length = 256, nullable = false)
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
