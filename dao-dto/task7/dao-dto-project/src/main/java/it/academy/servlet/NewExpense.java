package it.academy.servlet;

import it.academy.date.DaoFactory;
import it.academy.date.DatabaseName;
import it.academy.date.Expense;
import it.academy.date.Receiver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet (name="NewExpenseServlet", urlPatterns = "/new-expense")
public class NewExpense extends HttpServlet{
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
        Expense expense=new Expense();
//        expense.setNum(Integer.parseInt(req.getParameter("expense.num")));
        expense.setPaydate(req.getParameter("expense.date"));
        expense.setReceiver(Integer.parseInt(req.getParameter("expense.receiver")));
        expense.setValue(Double.parseDouble(req.getParameter("expense.value")));

        try {
            final int i = daoFactory.getDaoImpl().addExpense(expense);
            writer.println("Expense add to database with number "+i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
