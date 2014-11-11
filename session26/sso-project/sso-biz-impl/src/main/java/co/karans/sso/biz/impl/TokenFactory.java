package co.karans.sso.biz.impl;

import co.karans.sso.biz.SSOToken;
import co.karans.sso.biz.SSOUser;

/**
 * Created by morteza on 11/11/14.
 */
public interface TokenFactory {
    SSOToken createToken(SSOUser ssoUser);
}
