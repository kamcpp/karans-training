
<%@page import="example.facade.Facade"%>
<%@page import="example.facade.membership.FacadeUser"%>
<%@page import="javax.validation.Validator"%>
<%@page import="javax.validation.Validation"%>
<jsp:useBean id="loginForm" class="example.web.forms.LoginForm"></jsp:useBean>
<jsp:setProperty property="*" name="loginForm"/>

<%
Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
if(validator.validate(loginForm).size()!=0){
	FacadeUser fu = new FacadeUser();
	fu.setUsername(loginForm.getUserName());
	fu.setPassword(loginForm.getPassword());
	//if(Facade.getMembershipManager().ValidateUser(fu)){
		//response.encodeRedirectURL("/home.jsp");
//	}
	//else{
		//response.encodeRedirectURL("/login.jsp");
//	}
}

%>
<html>
<head>
</head>
<title>Karans and MFTV Login Page</title>
<body>

<form method="post">

User name <input name=username type="text" />
<br>
Password <input name="password" type="password">
<br>
<input type="submit" value="Login">
</form>

</body>
</html>