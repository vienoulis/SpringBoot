<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<form method="get" action="/admin">
    <p>
        Name: <input type="text" name="authName">
    </p>
    <p>
        Pass: <input type="password" name="authPassword">
    </p>
    <input type="submit" value="LogIn">
</form>
</body>
</html>
