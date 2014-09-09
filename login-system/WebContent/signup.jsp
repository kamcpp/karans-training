<%@page import="javax.validation.ConstraintViolation"%>
<%@page import="java.util.Set"%>
<%@page import="example.facade.membership.FacadeUser"%>
<%@page import="example.domain.entity.User"%>
<%@page import="example.facade.Facade"%>
<%@page import="javax.validation.Validator"%>
<%@page import="javax.validation.Validation"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="WEB-INF/tags.tld" prefix="k"%>
<jsp:useBean id="signupForm" class="example.web.forms.SignupForm"></jsp:useBean>
<jsp:setProperty property="*" name="signupForm" />
<k:validate bean="signupForm" />
<%
	Set<ConstraintViolation<Object>> violations = (Set<ConstraintViolation<Object>>) pageContext
			.getAttribute("violations");
	if (violations.size() == 0) {
		FacadeUser fu = new FacadeUser();
		fu.setName(signupForm.getName());
		fu.setFamily(signupForm.getFamily());
		fu.setUsername(signupForm.getUsername());
		fu.setPassword(signupForm.getPassword());
		fu.setEmail(signupForm.getEmail());
		Facade.getMembershipManager().addUser(fu);
		response.sendRedirect("login.jsp?from-signup=1");
	}
%>
<html>
<head>
</head>
<title>Karans and MFTV Login Page</title>
<body>

	<form method="post">

		Name <input name=name type="text" value="<%=signupForm.getName()%>" />
		<k:validationMessage field="name" />
		<br> family <input name=family type="text"
			value="<%=signupForm.getFamily()%>" />
		<k:validationMessage field="family" />
		<br> Password <input name="password" type="password">
		<k:validationMessage field="password" />
		<br> Password confirmation <input name="passwordConfirmation"
			type="password">
		<k:validationMessage field="passwordConfirmation" />
		<br> User name <input name="username" type="text"
			value="<%=signupForm.getUsername()%>" /> <br> Email <input
			name="email" type="text" value="<%=signupForm.getEmail()%>" />
		<k:validationMessage field="email" />
		<br> <input type="submit" value="Login">
	</form>

</body>
</html>