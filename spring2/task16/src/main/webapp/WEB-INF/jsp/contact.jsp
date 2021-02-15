<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring Tiles Contact Form</title>
</head>
<body>
<h2>Contact Manager</h2>
<form action="addContact.html" method="post">
    <label for="name">Contact name:</label><br>
    <input type="text" id="name" name="contact.firstname" value=""><br>
    <label for="lastname">Contact lastname:</label><br>
    <input type="text" id="lastname" name="contact.lastname" value=""><br>
    <label for="email">Contact email:</label><br>
    <input type="text" id="email" name="contact.email" value=""><br>
    <label for="phone">Contact phone:</label><br>
    <input type="text" id="phone" name="contact.phone" value=""><br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>