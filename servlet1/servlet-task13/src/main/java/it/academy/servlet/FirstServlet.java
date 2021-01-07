package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID=1l;

    @Override
    protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String coockieName="testCookie";
//        boolean checkCoockie=false;
//        Cookie[] cookies = req.getCookies();
//        if(cookies.length==0) {
//        final Cookie cookie = new Cookie("testCookie", "CookieValue");
//        cookie.setMaxAge(24*60*60);
//        resp.addCookie(cookie);
//        }
//          else {
//            for (int i = 0; i < cookies.length; i++) {
//                Cookie cookie1 = cookies[i];
//                if (coockieName.equals(cookie1.getName())) {
//                    checkCoockie = true;
//                }
//            }
//        }
//        for (Cookie cookie1 : cookies) {
//        }

        final PrintWriter out = resp.getWriter();
        final String realPath = getServletContext().getRealPath("/count.txt");
        final String s;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(realPath))) {
            s = bufferedReader.readLine();
        }
        int count=Integer.parseInt(s)+1;
        String num=Integer.toString(count);
        out.println("<html lang=\"en\"><head><title>First Servlet</title></head>");
        out.println("<body><h1>This is your visit number " + count +  "</h1>");
//        out.println("<p>check cookie: " + checkCoockie + "<p>");
        out.println("</body></html>");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(realPath, false))) {
        bufferedWriter.write(num);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
