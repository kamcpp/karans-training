<jsp:useBean id="loginForm"
	class="co.karans.phonebook.web.forms.LoginForm"></jsp:useBean>
<jsp:setProperty property="*" name="loginForm" />
<%
	if (request.getMethod().toUpperCase() == "POST") {
		if (loginForm.getUsername().equals("admin")
				&& loginForm.getPassword().equals("12345")) {
			Cookie tokenCookie = new Cookie("token", "logged-in");
			response.addCookie(tokenCookie);
			response.sendRedirect("books.jsp");
		}
	}
%>
<html>
<head>
</head>
<body>
	<form method="post">
		Username <input type="text" name="username" value="" /><br />
		Password <input type="password" name="password" value="" /><br /> <input
			type="submit" value="Login" />
	</form>
</body>
</html>