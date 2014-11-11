package co.karans.sso.eis.co.karans.sso.eis;

import co.karans.sso.dao.TokenDAO;
import co.karans.sso.dao.UserDAO;
import co.karans.sso.entity.Token;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;


@Stateless
@Local(TokenDAO.class)
public class FakeTokenDAO implements TokenDAO {
    @Override
    public long saveOrUpdate(Token user) {
        return 0;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<Token> getAll() {
        return null;
    }

    @Override
    public Token getById(long id) {
        return null;
    }
}
