package co.karans.session27.ejbs.impl;

import co.karans.session26.ejbs.ThirdLocal;
import co.karans.session27.domain.Book;
import co.karans.session27.eis.BookDAO;
import co.karans.session27.servicescalc.CalcService;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.Random;

@Stateless
@Local(ThirdLocal.class)
public class ThirdEJB implements ThirdLocal {

    @Inject
    private BookDAO bookDAO;

    @Inject
    private CalcService calcService;

    @Override
    public void generateRandomBook() {
        Book book = new Book();
        book.setName("Third Book");
        book.setPublishYear(2002);
        bookDAO.save(book);
        System.out.println(calcService.add(5, 7));
    }
}
