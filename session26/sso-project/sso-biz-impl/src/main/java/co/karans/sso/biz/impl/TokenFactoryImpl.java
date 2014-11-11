package co.karans.sso.biz.impl;

import co.karans.sso.biz.SSOToken;
import co.karans.sso.biz.SSOUser;

import java.util.UUID;


/**
 * Created by morteza on 11/11/14.
 */
public class TokenFactoryImpl implements TokenFactory {
    @Override
    public SSOToken createToken(SSOUser ssoUser) {
        String tokenValue= UUID.randomUUID().toString()+UUID.randomUUID().toString();
        SSOToken ssoToken=new SSOToken();
        ssoToken.setValue(tokenValue);
        return ssoToken;
    }
}
