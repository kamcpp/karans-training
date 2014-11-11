package co.karans.sso.biz.impl.fake;

import co.karans.sso.biz.Membership;
import co.karans.sso.biz.SSOUser;
import co.karans.sso.biz.exceptions.EmailAlreadyExistsException;
import co.karans.sso.biz.exceptions.UsernameAlreadyExistsException;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Membership.class)
public class MembershipFakeImpl implements Membership {

    SSOUser ssoUser;

    @Override
    public boolean isUsernameExists(String username) throws UsernameAlreadyExistsException {
        if (ssoUser.getUsername().equals("RAMA1"))
            return true;
        else
            try {
                throw new UsernameAlreadyExistsException();
            } catch (Exception e)

            {
                e.printStackTrace();
            }

        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        if (ssoUser.getEmail().equals("RAMA@RAMA.COM"))
            return true;
        else
            try {
                throw new UsernameAlreadyExistsException();
            } catch (Exception e)

            {
                e.printStackTrace();
            }

        return false;
    }

    @Override
    public void creatAccount(SSOUser ssoUser) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        ssoUser = new SSOUser();
        ssoUser.setName("RAMA");
        ssoUser.setFamily("RAMAFAMILY");
        ssoUser.setUsername("RAMA1");
        ssoUser.setPassword("123");
        ssoUser.setEmail("RAMA@RAMA.COM");

    }
}
