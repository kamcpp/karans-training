package co.karans.sso.ws.api;

import javax.jws.WebService;

@WebService
public interface SSOService {

    void createAccount(Account account) throws WSException;

    Token authenticate(String username, String passwordHash) throws WSException;

    void validateToken(Token token) throws WSException;

    void invalidateToken(Token token) throws WSException;

    void validateEmail(String email) throws WSException;

}
