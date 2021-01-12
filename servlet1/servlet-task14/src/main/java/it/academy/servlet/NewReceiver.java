package it.academy.servlet;
import it.academy.date.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet (name="NewReceiverServlet", urlPatterns = "/new-receiver")
public class NewReceiver extends HttpServlet{
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        Receiver receiver=new Receiver();
//        receiver.setNum(Integer.parseInt(req.getParameter("receiver.num")));
        receiver.setName(req.getParameter("receiver.name"));
        try {
            final int i = daoFactory.getDaoImpl().addReceiver(receiver);
            writer.println("Receiver add to database with number "+i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
