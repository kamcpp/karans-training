package co.karans.session27.ejbs.impl;

import co.karans.session26.ejbs.FirstLocal;
import co.karans.session26.ejbs.SecondLocal;
import co.karans.session27.domain.Book;
import co.karans.session27.eis.BookDAO;
import com.sun.xml.internal.ws.util.CompletedFuture;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.Date;
import java.util.concurrent.Future;

@Stateless
@Local(FirstLocal.class)
public class FirstEJB implements FirstLocal {

    @Inject
    private BookDAO bookDAO;

    @EJB
    private SecondLocal secondEJB;

    @Override
    public double calculate(double a, double b) {
        sleep();
        return a + b;
    }

    @Override
    @Asynchronous
    public Future<Double> calculateAsync(double a, double b) {
        sleep();
        return new AsyncResult<Double>(a + b);
    }

    @Override
    public void generateRandomBook() {
        Book book = new Book();
        book.setName("First Book");
        book.setPublishYear(2000);
        bookDAO.save(book);
        secondEJB.generateRandomBook();
    }

    @Schedule(hour = "*", minute = "*", second = "10")
    public void printTime() {
        System.out.println(new Date().toString());
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
