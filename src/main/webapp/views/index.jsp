<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">>
<head>
    <meta charset="UTF-8">
    <title>Hello World</title>
</head>
<body>
<h1>Hello World</h1>
<form action="addAlien">
    Enter your id: <input type="text" name="aid"><br>
    Enter your name: <input type="text" name="aname"><br>
    <input type="submit">
</form>
<hr>
<form action="getAlien" method="get">
    Enter your id: <input type="text" name="aid"><br>
    <input type="submit">
</form>
</body>
</html>