<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Tiles Contact Form</title>
</head>
<body>
<h2>Contact Manager</h2>
<form action="addContact.html" method="get">
    <label for="name">Contact name:</label><br>
    <input type="text" id="name" name="firstname" value=""><br>
    <label for="lastname">Contact lastname:</label><br>
    <input type="text" id="lastname" name="lastname" value=""><br>
    <label for="email">Contact email:</label><br>
    <input type="text" id="email" name="email" value=""><br>
    <label for="phone">Contact phone:</label><br>
    <input type="text" id="phone" name="phone" value=""><br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>