package it.academy.servlet;

import it.academy.date.Dao;
import it.academy.date.DaoFactory;
import it.academy.date.DatabaseName;
import it.academy.date.Receiver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ReceiverServlet", urlPatterns = "/receiver")
public class ReceiverServlet extends HttpServlet {
        DaoFactory daoFactory;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final String databaseName = config.getServletContext().getInitParameter("database.name");
        try {
            daoFactory = DaoFactory.getInstance(DatabaseName.valueOf(databaseName));
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("CP1251");
            String num=req.getParameter("num");

            Dao daoImpl = daoFactory.getDaoImpl();
            List<Receiver> receivers = new ArrayList<>();
            if(num==null){
                receivers = daoImpl.getReceivers();
            }
            else {
                Receiver receiver =daoImpl.getReceiver(Integer.parseInt(num));
                try {
                    receiver=daoImpl.getReceiver(Integer.parseInt(num));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                receivers = receiver != null ? List.of(receiver) : Collections.emptyList();
            }

            final PrintWriter out = resp.getWriter();
            for (Receiver receiver : receivers) {
                out.println("num="+ receiver.getNum()+ " name="+receiver.getName());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
