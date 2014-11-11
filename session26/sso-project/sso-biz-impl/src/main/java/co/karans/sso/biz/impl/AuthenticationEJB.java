package co.karans.sso.biz.impl;


import co.karans.sso.biz.Authentication;
import co.karans.sso.biz.SSOToken;
import co.karans.sso.biz.SSOUser;
import co.karans.sso.biz.exceptions.AuthenticationFailedException;
import co.karans.sso.dao.TokenDAO;
import co.karans.sso.dao.UserDAO;
import co.karans.sso.entity.Token;
import co.karans.sso.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
@Local(co.karans.sso.biz.Authentication.class)
public class AuthenticationEJB implements Authentication{
    @Inject
    private UserDAO userDAO;

    @Inject
    private TokenDAO tokenDAO;

    @Inject
    private TokenFactory tokenFactory;

    @Override
    public SSOToken authenticate(String username, String password) throws AuthenticationFailedException {
        User user = userDAO.getByUsernameAndPassword(username, password);
        if(user==null)
        {
            throw new AuthenticationFailedException();
        }
        SSOUser ssouser=convertUsers(user);
        SSOToken ssoToken = tokenFactory.createToken(ssouser);
        Token token=new Token();
        token.setUser(user);
        token.setValue(ssoToken.getValue());
        token.setIssueDate(new Date().getTime());
        token.setExpired(false);

        tokenDAO.saveOrUpdate(token);


        return ssoToken;
    }

    private SSOUser convertUsers(User user)
    {
        SSOUser ssouser=new SSOUser();
        ssouser.setName(user.getName());
        ssouser.setFamily(user.getFamily());
        ssouser.setUsername(user.getUsername());
        ssouser.setPassword(user.getPassword());
        ssouser.setEmail(user.getEmail());
        return  ssouser;
    }

    @Override
    public boolean validateToken(SSOToken ssoToken) {

        return false;
    }

    @Override
    public void invalidateToken(SSOToken ssoToken) {

    }
}
