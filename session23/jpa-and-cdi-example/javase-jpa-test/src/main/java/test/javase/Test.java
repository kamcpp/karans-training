package test.javase;

import test.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence.
                createEntityManagerFactory("jpa-cdi-test").
                createEntityManager();

        Book book = new Book();
        book.setName("Book1");
        book.setAuthor("Author1");

        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

        System.out.println("OK.");
    }
}
