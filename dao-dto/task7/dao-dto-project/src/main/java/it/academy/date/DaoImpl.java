package it.academy.date;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements Dao {

    public final Connection connection;

    public DaoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Receiver getReceiver(int num) {
        Receiver receiver= new Receiver();
        try {
            String query="SELECT num, name FROM listexpenses.receivers where num=?;";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(num));
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                receiver.setNum(resultSet.getInt("num"));
                receiver.setName(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return receiver;

    }

    @Override
    public ArrayList<Receiver> getReceivers() {
        ArrayList <Receiver> receivers=new ArrayList<>();
        try {
            final Statement statement = connection.createStatement();
            String query="SELECT * FROM listexpenses.receivers;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Receiver receiver=new Receiver();
                receiver.setNum(resultSet.getInt("num"));
                receiver.setName(resultSet.getString("name"));
                receivers.add(receiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receivers;
    }

    @Override
    public Expense getExpense(int num) {
        Expense expense= new Expense();
        try {
            String query="select num, paydate, receiver, value from expenses where num=? Order by expenses.num;";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(num));
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getString("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getDouble("value"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return expense;
    }

    @Override
    public ArrayList<Expense> getExpenses() {
        ArrayList<Expense> expenses=new ArrayList<>();
        try {
            final Statement statement = connection.createStatement();
            String query="select num, paydate, receiver, value from expenses Order by expenses.num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Expense expense=new Expense();
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getString("paydate"));
                expense.setReceiver(resultSet.getInt("receiver"));
                expense.setValue(resultSet.getDouble("value"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public int addReceiver(Receiver receiver) {
        return 0;
    }

    @Override
    public int addExpense(Expense expense) {
        return 0;
    }
}
