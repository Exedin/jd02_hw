<!DOCTYPE html>
<html lang="en">
<head >
    <title>Home page</title>
</head>
<body>


<h1>Form for web-crawler</h1>
<p>Enter data</p>

<div>
<form action="/web-crawler-homework/search" method="post" content="text/html; charset=UTF-8">
    <label for="seed-id">Seed:</label></br>
    <input type="text" id="seed-id" name="seed" value="https://auto.onliner.by" size="100"><br>

    <label for="terms-id">Terms:</label></br>
    <input type="text" id="terms-id" name="terms" value="Tesla, renault, Volkswagen, BMW" size="100"/><br>

    <input type="submit" value="Submit">
</form>
</div>
</body>
</html>