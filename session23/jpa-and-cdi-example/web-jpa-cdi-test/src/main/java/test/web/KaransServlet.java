package test.web;

import test.domain.Book;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KaransServlet extends HttpServlet{

    @PersistenceContext(unitName = "xyz")
    private EntityManager entityManager;

    @Resource(lookup = "java:jboss/datasources/karansDS")
    private DataSource dataSource;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setName("Book2");
        book.setAuthor("Author2");

        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());

        try {
            userTransaction.begin();
            entityManager.persist(book);
            userTransaction.commit();
            printWriter.write("OK.");

            Query nativeQuery = entityManager.createNativeQuery("");
        } catch (Exception e) {
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            printWriter.write("FAILED!");
        }

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jpa_cdi_test.book VALUES (100, 'test', 'test')");
            preparedStatement.execute();
            printWriter.write("OK.");
            connection.close();
            printWriter.write("CLOSED.");
        } catch (SQLException e) {
            e.printStackTrace();
            printWriter.write("FAILED: " + e.getMessage());
        }
        printWriter.flush();
    }
}
