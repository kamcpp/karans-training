package servlets;

import mdb_test.api.MessageProducerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @EJB
    private MessageProducerLocal messageProducerLocal;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        messageProducerLocal.sendMessage("FROM SERVLET");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.write("OK");
        printWriter.flush();
    }
}
