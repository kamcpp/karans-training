package co.karans.sso.biz.impl;


import co.karans.sso.biz.Authentication;
import co.karans.sso.biz.SSOToken;
import co.karans.sso.biz.exceptions.AuthenticationFailedException;
import co.karans.sso.dao.TokenDAO;
import co.karans.sso.dao.UserDAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(co.karans.sso.biz.Authentication.class)
public class AuthenticationEJB implements Authentication{
    @Inject
    private UserDAO userDAO;

    @Inject
    private TokenDAO tokenDAO;

    @Override
    public SSOToken authenticate(String username, String password) throws AuthenticationFailedException {

        return null;
    }

    @Override
    public boolean validateToken(SSOToken ssoToken) {
        return false;
    }

    @Override
    public void invalidateToken(SSOToken ssoToken) {

    }
}
