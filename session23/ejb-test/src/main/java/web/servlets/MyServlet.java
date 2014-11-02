package web.servlets;

import ejb_test.method1.HelloWorldEJB;
import ejb_test.method2.NumberGeneratorEJB;
import ejb_test.method2.NumberGeneratorLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet  extends HttpServlet {

    //@Resource(lookup = "java:module/HelloWorldEJB")
    @EJB
    private HelloWorldEJB helloWorldEJB;

    @EJB
    private NumberGeneratorLocal numberGenerator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.write(helloWorldEJB.sayHello());
        printWriter.write("<br />");
        printWriter.write(numberGenerator.generate());
        printWriter.flush();
    }
}
