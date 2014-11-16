package co.karans.session27.services.impl;

import co.karans.session26.ejbs.BookLocal;
import co.karans.session26.ejbs.FirstLocal;
import co.karans.session27.services.Book;
import co.karans.session27.services.BookService;

import javax.ejb.EJB;
import javax.jws.WebService;

@WebService(endpointInterface = "co.karans.session27.services.BookService")
public class BookServiceImpl implements BookService {

    @EJB
    private BookLocal bookEJB;

    @EJB
    private FirstLocal firstEJB;

    @Override
    public long save(Book book) {
        co.karans.session26.ejbs.Book ejbBook = new co.karans.session26.ejbs.Book();
        ejbBook.setName(book.getName());
        ejbBook.setPublishYear(book.getPublishYear());
        return bookEJB.save(ejbBook);
    }

    @Override
    public void generateBooks() {
        firstEJB.generateRandomBook();
    }
}
