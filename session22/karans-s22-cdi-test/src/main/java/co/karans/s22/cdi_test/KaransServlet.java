package co.karans.s22.cdi_test;


import co.karans.s22.cdi_test.qualifiers.Random;
import co.karans.s22.cdi_test.qualifiers.Sequential;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class KaransServlet extends HttpServlet {

    @Inject
    private HelloEchoer helloEchoer;

    @Inject
    @Random
    private NumberGenerator randomNumberGenerator;

    @Inject
    @Sequential
    private NumberGenerator sequentialNumberGenerator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.write(helloEchoer.sayHello());
        pw.write("<br />");
        pw.write("" + randomNumberGenerator.generate());
        pw.write("<br />");
        pw.write("" + sequentialNumberGenerator.generate());
        pw.flush();
    }
}
