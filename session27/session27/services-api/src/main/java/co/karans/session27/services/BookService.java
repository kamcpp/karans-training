package co.karans.session27.services;

import javax.jws.WebService;

@WebService
public interface BookService {
    long save(Book book);

    void generateBooks();
}
