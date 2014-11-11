package co.karans.sso.ws.api;

import co.karans.sso.biz.exceptions.AuthenticationFailedException;
import co.karans.sso.biz.exceptions.EmailAlreadyExistsException;
import co.karans.sso.biz.exceptions.UsernameAlreadyExistsException;

import javax.jws.WebService;

@WebService
public interface SSOService {

    void createAccount(Account account) throws WSException, EmailAlreadyExistsException, UsernameAlreadyExistsException;

    Token authenticate(String username, String passwordHash) throws WSException, AuthenticationFailedException;

    void validateToken(Token token) throws WSException;

    void invalidateToken(Token token) throws WSException;

    void validateEmail(String email) throws WSException;

}
