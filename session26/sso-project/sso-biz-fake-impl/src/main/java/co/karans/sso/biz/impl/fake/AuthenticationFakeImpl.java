package co.karans.sso.biz.impl.fake;

import co.karans.sso.biz.Authentication;
import co.karans.sso.biz.SSOToken;
import co.karans.sso.biz.exceptions.AuthenticationFailedException;
import co.karans.sso.biz.exceptions.BizException;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Authentication.class)
public class AuthenticationFakeImpl implements Authentication {


    private SSOToken ssoToken;



    @Override
    public SSOToken authenticate(String username, String password) throws AuthenticationFailedException {
        System.out.println("authentication is create");
        ssoToken = new SSOToken();
        ssoToken.setValue("12345T");
        return ssoToken;
    }

    @Override
    public boolean validateToken(SSOToken ssoToken) {
        if (ssoToken.getValue().equals("12345T"))
            return true;
        else
            try {
                throw new BizException();
            } catch (BizException e) {
                e.printStackTrace();

            }
        return false;
    }

    @Override
    public void invalidateToken(SSOToken ssoToken) {
        ssoToken.setValue(null);

    }
}
