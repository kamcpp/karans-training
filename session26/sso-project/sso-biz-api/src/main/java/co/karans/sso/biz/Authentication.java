package co.karans.sso.biz;


import co.karans.sso.biz.exceptions.AuthenticationFailedException;

public interface Authentication {
    public SSOToken authenticate(String username,String password) throws AuthenticationFailedException;
    public boolean validateToken(SSOToken ssoToken);
    public void invalidateToken(SSOToken ssoToken);
}
