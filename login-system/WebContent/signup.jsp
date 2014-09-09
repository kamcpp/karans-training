<%@page import="example.facade.membership.FacadeUser"%>
<%@page import="example.domain.entity.User"%>
<%@page import="example.facade.Facade"%>
<%@page import="javax.validation.Validator"%>
<%@page import="javax.validation.Validation"%>
<%@taglib uri="WEB-INF/tags.tld" prefix="k"%>
<jsp:useBean id="signupForm" class="example.web.forms.SignupForm"></jsp:useBean>
<jsp:setProperty property="*" name="signupForm" />
<k:validate bean="signupForm" />
<k:validated>
	<%
		FacadeUser uf = new FacadeUser();
			uf.setName(signupForm.getName());
			uf.setFamily(signupForm.getFamily());
			uf.setUsername(signupForm.getUsername());
			uf.setPassword(signupForm.getPassword());
			Facade.getMembershipManager().addUser(uf);
	%>
</k:validated>
<html>
<head>
</head>
<title>Karans and MFTV Login Page</title>
<body>

	<form method="post">

		Name <input name=name type="text" />
		<k:validationMessage field="name" />
		<br> family <input name=family type="text" />
		<k:validationMessage field="family" />
		<br> Password <input name="password" type="password">
		<k:validationMessage field="password" />
		<br> Password confirmation <input name="passwordConfirmation"
			type="password">
		<k:validationMessage field="passwordConfirmation" />
		<br> User name <input name=username type="text" /> <br>
		Email <input name=email type="text" />
		<k:validationMessage field="email" />
		<br> <input type="submit" value="Login">
	</form>

</body>
</html>