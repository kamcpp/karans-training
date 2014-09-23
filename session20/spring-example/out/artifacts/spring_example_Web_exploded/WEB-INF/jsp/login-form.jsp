<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Create Account</title>
    <style>
        .error {
            color: red;
            font-family: verdana, tahoma;
        }
    </style>
</head>
<body dir="rtl">
    <a href="/signup">Create Account</a>
    <br />
    <form:form action="/login" method="post" commandName="loginForm">
        <spring:message  code="form.login.label.username" /> <input type="text" name="username" value="" /><form:errors path="username" cssClass="error"/><br />
        <spring:message  code="form.login.label.password" /> <input type="password" name="password" value="" /><form:errors path="password"/><br />
        <input type="submit" value="<spring:message code="form.login.button.login" />" />
    </form:form>
</body>
</html>
