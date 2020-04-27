<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<P>
    User name: <c:out value="${user.name}"/>
</P>
<p>
    User age: <c:out value="${user.age}"/>
</p>
<a href="/logout" name="LogOut">Log out.</a>
</body>
</html>
