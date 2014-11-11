package co.karans.sso.biz;

public class SSOToken {
    private String value;

    public SSOToken() {
    }

    public SSOToken(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
