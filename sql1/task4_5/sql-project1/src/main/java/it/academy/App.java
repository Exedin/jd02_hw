package it.academy;

import java.sql.*;

public class App
{
//    static String [] args=new String [] {"10, '2020-5-05', 1, 13555", "11, '2011-5-11', 2, 18555"};


    public static void main( String[] args )
    {
        for (String arg : args) {
            System.out.println(arg.toString());
        }

        update("insert into expenses values ("+args[0]+");");

        extracted();

//        delete();


    }

    private static void update(String s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            String update = s;
            final int resultSet = statement.executeUpdate(update);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void extracted() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            String query="SELECT expenses.num, paydate, name, value from expenses,receivers where receiver=receivers.num Order by expenses.num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int num=resultSet.getInt(1);
                Date date=resultSet.getDate(2);
                String name=resultSet.getString(3);
                int value=resultSet.getInt(4);
                System.out.printf("num=%d, paydate=%s, name=%s, value=%d \n", num, date.toString(), name, value );

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void delete() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            String delete="delete from expenses where num=10;";
            final int resultSet = statement.executeUpdate(delete);

            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
