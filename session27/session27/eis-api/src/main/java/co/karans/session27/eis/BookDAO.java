package co.karans.session27.eis;

import co.karans.session27.domain.Book;

import java.util.Set;

public interface BookDAO {

    long save(Book book);

    void update(Book book);

    void delete(Book book);

    Set<Book> getAll();

    Book getById(long id);
}
