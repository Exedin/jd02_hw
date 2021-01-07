package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestHeader extends HttpServlet {
    private static final long serialVersionUID=1l;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String browser = req.getHeader("User-Agent");
        final PrintWriter out = resp.getWriter();
        out.println("<html lang=\"en\"><head><title>First Servlet</title></head>");
        out.println("<body><h1>browser "+browser+" </h1>");
        out.println("</body></html>");

//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        Enumeration e = req.getHeaderNames();
//        while (e.hasMoreElements()) {
//            String name = (String)e.nextElement();
//            String value = req.getHeader(name);
//            out.println(name + " = " + value +"; \n");
//            out.println();
//        }

//        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
//        Browser browser = userAgent.getBrowser();
//
//        String browserName = browser.getName();
//        //or
//        // String browserName = browser.getGroup().getName();
//        Version browserVersion = userAgent.getBrowserVersion();
//        PrintWriter out = resp.getWriter();
//        out.println("The user is using browser " + browserName + " - version " + browserVersion);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
