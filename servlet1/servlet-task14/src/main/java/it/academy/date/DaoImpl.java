package it.academy.date;

import java.sql.*;
import java.util.ArrayList;

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
            String query="select expenses.num, paydate, name, value from expenses,receivers where receiver=receivers.num and expenses.num=?;";
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Integer.toString(num));
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getString("paydate"));
                expense.setReceiver(resultSet.getString("name"));
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
            String query="select expenses.num, paydate, name, value from expenses,receivers where receiver=receivers.num Order by expenses.num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Expense expense=new Expense();
                expense.setNum(resultSet.getInt("num"));
                expense.setPaydate(resultSet.getString("paydate"));
                expense.setReceiver(resultSet.getString("name"));
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
        int num=chooseFreeNumReceiver();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into receivers values (?, ?);")) {

            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, receiver.getName());

            System.out.println("create=" + preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return num;
    }

    @Override
    public int addExpense(Expense expense) {
        int num=chooseFreeNumExpense();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into expenses values (?, ?, ?, ?);")) {
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, expense.getPaydate());
            preparedStatement.setString(3, expense.getReceiver());
            preparedStatement.setDouble(4, expense.getValue());
            System.out.println("create=" + preparedStatement.executeUpdate());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return num;
        }

    private int chooseFreeNumExpense() {
        int num=0;
        try {
            final Statement statement = connection.createStatement();
            String query="SELECT num from expenses Order by num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                num=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num+1;
    }
    private int chooseFreeNumReceiver() {
        int num=0;
        try {
            final Statement statement = connection.createStatement();
            String query="SELECT num from receivers Order by num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                num=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num+1;
    }
}
