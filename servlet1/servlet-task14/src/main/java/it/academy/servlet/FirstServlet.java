package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID=1l;

    @Override
    protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("CP1251");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = getServletContext().getInitParameter("database.url");
            String userName= getServletContext().getInitParameter("database.user");
            String userPassword= getServletContext().getInitParameter("database.password");
            final PrintWriter out = resp.getWriter();
//            out.println(dbURL);
//            out.println(userName);
//            out.println(userPassword);
            Connection connection= DriverManager.getConnection(dbURL, userName, userPassword);
            final Statement statement = connection.createStatement();
            String query="SELECT expenses.num, paydate, name, value from expenses,receivers where receiver=receivers.num Order by expenses.num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int num=resultSet.getInt(1);
                Date date=resultSet.getDate(2);
                String name=resultSet.getString(3);
                int value=resultSet.getInt(4);
                out.printf("num=%d, paydate=%s, name=%s, value=%d \n", num, date.toString(), name, value );
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
