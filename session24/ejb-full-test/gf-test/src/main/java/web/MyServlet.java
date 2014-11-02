package web;

import ejb.CounterEJB;
import ejb.GlobalCounter;
import ejb.GlobalCounterInterface;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    // @Resource(lookup = "java:global/gf_test/CounterEJB")
    // private CounterEJB counterEJB;

    @EJB
    private GlobalCounterInterface globalCounter;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CounterEJB counterEJB = null;
        try {
            if (req.getSession().getAttribute("ejb") == null) {
                CounterEJB ejb = (CounterEJB) new InitialContext().lookup("java:global/gf_test/CounterEJB");
                req.getSession().setAttribute("ejb", ejb);
            }
            counterEJB = (CounterEJB) req.getSession().getAttribute("ejb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html");
        PrintWriter printWriter = new PrintWriter(resp.getOutputStream());
        printWriter.write("HELLO FROM GlassFish!");
        printWriter.write("<br />");
        counterEJB.increase();
        printWriter.write("" + counterEJB.getCounter());
        printWriter.write("<br />");
        globalCounter.increase();
        printWriter.write("" + globalCounter.getC());
        printWriter.flush();
    }
}
