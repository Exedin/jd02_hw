package it.academy;

import java.sql.*;
import java.util.regex.Pattern;

public class AppTask4
{

    public static void main( String[] args ){

        for (String arg : args) {
            System.out.print(arg.toString()+ " ");
        }
        System.out.println();

        if (args.length!=3&&args.length!=4) {
            System.out.println("Enter date about expenses in format '1 2020-05-05 2 1000':\n" +
                    "where:\n" +
                    "1          - number payment (optional field);\n" +
                    "2020-05-05 - date payment in format YYYY-MM-DD; \n" +
                    "2          - recipient; \n" +
                    "1000       - sum of money.");
        }

        if (args.length==4) {
            if (checkFourArgs(args)){
            update("insert into expenses values (" + args[0] + ", '" + args[1] + "', " + args[2] + ", " + args[3] + ");");
            }
        }
        if (args.length==3) {
            if (checkThreeArgs(args)){
            update("insert into expenses values (" + chooseFreeNum() + ", '" + args[0] + "', " + args[1] + ", " + args[2] + ");");
            }
        }
        System.out.println("Actual Database: ");
        extracted();

    }

    private static boolean checkThreeArgs(String[] args) {
        boolean dateCheck = Pattern.matches("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" +
                "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" +
                "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$", args[0]);
        if (dateCheck==false) {
        System.out.println("You should choose correct date in format YYYY-MM-DD.");
        }
        final boolean receiversNum = checkReceiversNum(args[1]);
        boolean valueCheck = Pattern.matches("(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])", args[2]);
        if (dateCheck&&receiversNum&&valueCheck) return true;
        else return false;
    }

    private static boolean checkFourArgs(String[] args) {
        final boolean numCheck = checkNum(args[0]);

        boolean dateCheck = Pattern.matches("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" +
                "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" +
                "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$", args[1]);
        if (dateCheck==false) {
            System.out.println("You should choose correct date in format YYYY-MM-DD.");
        }

        final boolean receiversNum = checkReceiversNum(args[2]);
        boolean valueCheck = Pattern.matches("(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])", args[3]);
        if (numCheck && dateCheck && receiversNum && valueCheck) return true;
        else return false;
    }


    private static void update(String s) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL = "jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            final int executeUpdate = statement.executeUpdate(s);
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

    private static boolean checkNum(String s) {
        boolean result=true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            String query="SELECT num from expenses Order by num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int num=resultSet.getInt(1);
                String number=Integer.toString(num);
                if (s.equals(number)) {
                    System.out.println("You should choose correct payment number, because this number exist.");
                    result=false;
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static int chooseFreeNum() {
        int num=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            String query="SELECT num from expenses Order by num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                num=resultSet.getInt(1);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return num+1;
    }

    private static boolean checkReceiversNum(String s) {
        boolean result=false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbURL="jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
            final Statement statement = connection.createStatement();
            String query="SELECT num from receivers Order by num;";
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int num=resultSet.getInt(1);
                String number=Integer.toString(num);
                if (s.equals(number)) {
                    result=true;
                }
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         if (result==false) System.out.println("You should choose correct receivers number, because this number does not exist.");
        return result;
    }

//    private static void delete(String delete) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String dbURL="jdbc:mysql://localhost:3306/ListExpenses?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//            final Connection connection = DriverManager.getConnection(dbURL, "root", "root");
//            final Statement statement = connection.createStatement();
//
//            final int resultSet = statement.executeUpdate(delete);
//
//            statement.close();
//            connection.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
