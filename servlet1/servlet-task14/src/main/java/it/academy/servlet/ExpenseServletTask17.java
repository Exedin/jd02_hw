package it.academy.servlet;

import it.academy.date.Dao;
import it.academy.date.DaoFactory;
import it.academy.date.DatabaseName;
import it.academy.date.Expense;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "ExpenseServletTask17", urlPatterns = "/expense-task17")
public class ExpenseServletTask17 extends HttpServlet {
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
            List<Expense> expenses = new ArrayList<>();
            if(num==null){
                expenses = daoImpl.getExpenses();
            }
            else {
                Expense expense =daoImpl.getExpense(Integer.parseInt(num));
                try {
                    expense=daoImpl.getExpense(Integer.parseInt(num));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                expenses = expense != null ? List.of(expense) : Collections.emptyList();
            }
            req.setAttribute("expenses", expenses);
            req.getRequestDispatcher("/jsp/task17.jsp").forward(req,resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}