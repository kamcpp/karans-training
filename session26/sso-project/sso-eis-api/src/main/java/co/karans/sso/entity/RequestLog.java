package co.karans.sso.entity;

import javax.persistence.*;

@Entity
@Table(name="request_log", schema = "sso")
public class RequestLog {
    @Id
    @GeneratedValue
    private long Id;
    @Column(name="issue_date", nullable = false)
    private long issueDate;
    @Column(name="details", length = 2048, nullable = false)
    private String details;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = true)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="token_id", nullable = true)
    private Token token;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
