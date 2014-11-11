package co.karans.sso.entity;

import javax.persistence.*;

@Entity
@Table(name="token", schema="sso")
public class Token {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="issue_date", nullable =  false)
    private long issueDate;
    @Column(name="expiration_date", nullable =  true)
    private Long expirationDate;
    @Column(name="expired", nullable =  false)
    private boolean expired;
    @Column(name="value", length = 512, nullable =  false)
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public long getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(long issueDate) {
        this.issueDate = issueDate;
    }

    public Long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
