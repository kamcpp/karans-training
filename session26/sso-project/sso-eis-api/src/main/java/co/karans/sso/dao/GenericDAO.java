package co.karans.sso.dao;

import co.karans.sso.entity.User;

import java.util.List;

public interface GenericDAO <E> {

    public long saveOrUpdate(User user);

    public void delete(long id);

    public List<E> getAll();

    public E getById(long id);
}
