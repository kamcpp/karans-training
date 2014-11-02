package web_test;

import my_ejb_api.MyNumberGeneratorLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @EJB
    private MyNumberGeneratorLocal numberGenerator;

    public MyServlet() {
        System.out.println("CTOR: SERVLET");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.write(numberGenerator.generateNumber());
        printWriter.flush();
    }
}
