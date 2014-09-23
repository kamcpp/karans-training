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
    <form:form action="/signup" method="post" commandName="signupForm">
        <spring:message  code="form.signup.label.name" /> <input type="text" name="name" value="${signupForm.name}" /><form:errors path="name" cssClass="error"/><br />
        <spring:message  code="form.signup.label.username" /> <input type="text" name="username" value="${signupForm.username}" /><form:errors path="username" cssClass="error"/><br />
        <spring:message  code="form.signup.label.password" /> <input type="password" name="password" value="" /><form:errors path="password"/><br />
        <spring:message  code="form.signup.label.passwordConfirmation" /> <input type="password" name="passwordConfirmation" value="" /><form:errors path="passwordConfirmation"/><br />
        <input type="submit" value="<spring:message code="form.signup.button.signup" />" />
    </form:form>
</body>
</html>
