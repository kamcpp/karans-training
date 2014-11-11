package co.karans.sso.ws.impl;

import co.karans.sso.biz.Authentication;
import co.karans.sso.biz.Membership;
import co.karans.sso.biz.SSOToken;
import co.karans.sso.biz.SSOUser;
import co.karans.sso.biz.exceptions.AuthenticationFailedException;
import co.karans.sso.biz.exceptions.EmailAlreadyExistsException;
import co.karans.sso.biz.exceptions.UsernameAlreadyExistsException;
import co.karans.sso.ws.api.Account;
import co.karans.sso.ws.api.SSOService;
import co.karans.sso.ws.api.Token;
import co.karans.sso.ws.api.WSException;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "co.karans.sso.ws.api.SSOService")
public class SSOServiceImpl implements SSOService {


    @EJB
    private Membership membership;

    @EJB
    private Authentication authentication;

    @Override
    public void createAccount(Account account) throws WSException, EmailAlreadyExistsException, UsernameAlreadyExistsException {
        SSOUser ssoUser = new SSOUser();
        ssoUser.setName(account.getName());
        ssoUser.setFamily(account.getFamily());
        ssoUser.setUsername(account.getUsername());
        ssoUser.setPassword(account.getPassword());
        ssoUser.setEmail(account.getEmail());
        try {
            membership.creatAccount(ssoUser);
        } catch (UsernameAlreadyExistsException e) {
            e.printStackTrace();
        } catch (EmailAlreadyExistsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Token authenticate(String username, String passwordHash) throws WSException, AuthenticationFailedException {
        SSOToken ssoToken;
        Token token = new Token();
        ssoToken = authentication.authenticate(username, passwordHash);
        token.setValue(ssoToken.getValue());
        return token;
    }

    @Override
    public void validateToken(Token token) throws WSException {
        SSOToken ssoToken = new SSOToken();
        ssoToken.setValue(token.getValue());
        authentication.validateToken(ssoToken);

    }

    @Override
    public void invalidateToken(Token token) throws WSException {
        SSOToken ssoToken = new SSOToken();
        ssoToken.setValue(token.getValue());
        authentication.invalidateToken(ssoToken);
    }

    @Override
    public void validateEmail(String email) throws WSException {
        membership.isEmailExists(email);

    }
}
