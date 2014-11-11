package co.karans.sso.biz;

import co.karans.sso.biz.exceptions.EmailAlreadyExistsException;
import co.karans.sso.biz.exceptions.UsernameAlreadyExistsException;

public interface Membership {
    public boolean isUsernameExists(String username);
    public boolean isEmailExists(String email);
    public void creatAccount(SSOUser ssoUser) throws UsernameAlreadyExistsException,EmailAlreadyExistsException;
}

