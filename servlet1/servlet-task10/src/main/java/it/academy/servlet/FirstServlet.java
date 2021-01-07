package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID=1l;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        String uname = req.getParameter("user.name");
        String uphone = req.getParameter("user.phone");
        String umail = req.getParameter("user.email");

        boolean checkName=(Pattern.matches("[A-Za-zА-Яа-я0-9_\\-]+", uname));
        boolean checkPhone=(Pattern.matches("^\\+\\d{3}\\(\\d{2}\\)\\d{3}-\\d{2}-\\d{2}$", uphone));
        boolean checkMail=(Pattern.matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$", umail));

        if (checkName&&(checkMail||checkPhone)) {
            out.println("<html lang=\"en\"><head><title>First Servlet</title></head>");
            out.println("<body><h1>This is your contact date</h1>");
            out.println("<p>your name: " + uname + "<p>");
//            out.println("<p>checkName: " + checkName + "<p>");
            out.println("<p>your phone: " + uphone + "<p>");
//            out.println("<p>checkPhone: " + checkPhone + "<p>");
            out.println("<p>your email: " + umail + "<p>");
//            out.println("<p>checkMail: " + checkMail + "<p>");
            out.println("</body></html>");
        }
        if(!checkName) {
            out.println("<html lang=\"en\"><head><title>First Servlet</title></head>");
            out.println("<body><h1>Check your name and try again </h1>");
            out.println("</body></html>");
        }
        if (!checkMail&&!checkPhone)
        {
            out.println("<html lang=\"en\"><head><title>First Servlet</title></head>");
            out.println("<body><h1>Check you phone or email and try again </h1>");
            out.println("</body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
