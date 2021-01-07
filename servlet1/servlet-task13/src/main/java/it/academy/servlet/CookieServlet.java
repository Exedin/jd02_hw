package it.academy.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class CookieServlet extends HttpServlet implements Servlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performTask(request, response);
    }
    protected void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Writer out = response.getWriter();
            out.write("My counter for last day: ");
            out.write(String.valueOf(
                    coockieCounter(request, response)));
            out.flush();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(
                    "Failed to handle request: " + e.toString());
        }
    }

    protected int coockieCounter(
            HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if ("counter".equals(cookies[i].getName())) {
                    String counterStr = cookies[i].getValue();
                    int counterValue;
                    try {
                        counterValue = Integer.parseInt(counterStr);
                    } catch (NumberFormatException e) {
                        counterValue = 0;
                    }
                    counterValue++;
                    Cookie counterCookie =
                            new Cookie("counter", String.valueOf(counterValue));
                    counterCookie.setMaxAge(60*60*24);
                    resp.addCookie(counterCookie);
                    return counterValue;
                }
            }
        }
        Cookie counterCookie = new Cookie("counter", "1");
        counterCookie.setMaxAge(60*60*24);
        resp.addCookie(counterCookie);
        return 1;
    }
}