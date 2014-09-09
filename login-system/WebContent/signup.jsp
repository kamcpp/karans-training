<%@page import="example.domain.entity.User"%>
<%@page import="example.facade.Facade"%>
<%@page import="javax.validation.Validator"%>
<%@page import="javax.validation.Validation"%>
<jsp:useBean id="signupForm" class="example.web.forms.SignupForm"></jsp:useBean>
<jsp:setProperty property="*" name="signupForm"/>
<%

if(request.getMethod().toUpperCase().equals("POST")){
	
	Validator validator= Validation.buildDefaultValidatorFactory().getValidator();
	
	if(validator.validate(signupForm).size()==0){
		
	}
	else{
		
	}
	
}
%>
<html>
<head>
</head>
<title>Karans and MFTV Login Page</title>
<body>

	<form method="post">

		Name <input name=name type="text" /> <br> 
		family <input name=family type="text" /> <br> 
		Password <input name="password" type="password"> <br> 
		Password confirmation <input name="passwordConfirmation" type="password"> <br>
		User name <input name=username type="text" /> <br> 
		 <input type="submit" value="Login">
	</form>

</body>
</html>