<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Expenses</title>
</head>
<body>
<%@page import ="it.academy.date.Expense" %>
<%@page import="java.util.*" %>
<%List<Expense> expenses=(List<Expense>) request.getAttribute("expenses");
for (Expense expense : expenses) {
                out.write("num=" + expense.getNum() + " paydate=" + expense.getPaydate() + " receiver=" + expense.getReceiver() + " value=" + expense.getValue()+"<br/>");
            };%>
</body>
</html>