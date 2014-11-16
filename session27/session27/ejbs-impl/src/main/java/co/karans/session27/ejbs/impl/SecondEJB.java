package co.karans.session27.ejbs.impl;

import co.karans.session26.ejbs.SecondLocal;
import co.karans.session26.ejbs.ThirdLocal;
import co.karans.session27.domain.Book;
import co.karans.session27.eis.BookDAO;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(SecondLocal.class)
public class SecondEJB implements SecondLocal {

    @Inject
    private BookDAO bookDAO;

    @EJB
    private ThirdLocal thirdEJB;

    @Override
    public void generateRandomBook() {
        Book book = new Book();
        book.setName("Second Book");
        book.setPublishYear(2001);
        bookDAO.save(book);
        thirdEJB.generateRandomBook();
    }
}
