package co.karans.sso.biz.impl;

import co.karans.sso.biz.Membership;
import co.karans.sso.biz.SSOUser;
import co.karans.sso.biz.exceptions.EmailAlreadyExistsException;
import co.karans.sso.biz.exceptions.UsernameAlreadyExistsException;
import co.karans.sso.dao.UserDAO;
import co.karans.sso.entity.User;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(Membership.class)
public class MembershipEJB implements Membership{
    @Inject
    private UserDAO userDAO;

    @Override
    public boolean isUsernameExists(String username) {
        if((userDAO.getByUsername(username))==null)
        {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean isEmailExists(String email) {
        if((userDAO.getByEmail(email))==null)
        {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void creatAccount(SSOUser ssoUser) throws UsernameAlreadyExistsException, EmailAlreadyExistsException {
        if(userDAO.getByUsername(ssoUser.getUsername())!=null)
        {
            throw new UsernameAlreadyExistsException();
        }
        if(userDAO.getByEmail(ssoUser.getEmail())!=null)
        {
            throw new EmailAlreadyExistsException();
        }
        User user=convertUsers(ssoUser);

        userDAO.saveOrUpdate(user);
        //TODO: send email to user

    }
    private User convertUsers(SSOUser user)
    {
        User ssouser=new User();
        ssouser.setName(user.getName());
        ssouser.setFamily(user.getFamily());
        ssouser.setUsername(user.getUsername());
        ssouser.setPassword(user.getPassword());
        ssouser.setEmail(user.getEmail());
        return  ssouser;
    }
}
