<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>WELCOME HOME</title>
</head>
<body>
    <a href="/logout">Logout</a><br />
    <h1>WELCOME HOME ${u.username}</h1>
</body>
</html>
