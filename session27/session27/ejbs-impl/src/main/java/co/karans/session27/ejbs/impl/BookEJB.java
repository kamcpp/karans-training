package co.karans.session27.ejbs.impl;

import co.karans.session26.ejbs.Book;
import co.karans.session26.ejbs.BookLocal;
import co.karans.session27.eis.BookDAO;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(BookLocal.class)
public class BookEJB implements BookLocal {

    @Inject
    private BookDAO bookDAO;

    @Override
    public long save(Book book) {
        co.karans.session27.domain.Book persistingBook = new co.karans.session27.domain.Book();
        persistingBook.setName(book.getName());
        persistingBook.setPublishYear(book.getPublishYear());
        return bookDAO.save(persistingBook);
    }
}
