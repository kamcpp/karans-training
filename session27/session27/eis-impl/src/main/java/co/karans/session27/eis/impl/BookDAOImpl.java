package co.karans.session27.eis.impl;

import co.karans.session27.domain.Book;
import co.karans.session27.eis.BookDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

public class BookDAOImpl implements BookDAO {

    @PersistenceContext(unitName = "test")
    private EntityManager entityManager;

    @Override
    public long save(Book book) {
        entityManager.persist(book);
        return book.getId();
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public Set<Book> getAll() {
        return new HashSet<Book>(entityManager.createQuery("SELECT book FROM Book book").getResultList());
    }

    @Override
    public Book getById(long id) {
        return (Book)(entityManager.createQuery("SELECT book FROM Book book WHERE book.id = ?").setParameter(1, id).getSingleResult());
    }
}
