package co.karans.sso.biz.impl.fake;

import co.karans.sso.biz.Membership;
import co.karans.sso.biz.SSOUser;
import co.karans.sso.biz.exceptions.EmailAlreadyExistsException;
import co.karans.sso.biz.exceptions.UsernameAlreadyExistsException;

public class MembershipFakeImpl implements Membership {

    
    @Override
    public boolean isUsernameExists(String username) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        return false;
    }

    @Override
    public void creatAccount(SSOUser ssoUser) {

    }
}
