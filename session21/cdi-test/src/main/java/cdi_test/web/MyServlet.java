package cdi_test.web;

import cdi_test.HelloEchoer;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {

    @Inject
    private HelloEchoer helloEchoer;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletResponse.setStatus(200);
        PrintWriter pw = new PrintWriter(httpServletResponse.getOutputStream());
        pw.write("<h1>" + helloEchoer.echoHello() +"</h1>");
        pw.flush();
    }
}
