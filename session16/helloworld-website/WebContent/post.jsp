
<%@page import="karans.s16.web.Person"%>
<%
	String nParameter = request.getParameter("n");
	int number = 0;
	if (nParameter != null) {
		number = Integer.parseInt(nParameter);
	}
	number++;

	Person p = new Person();
	p.setName("Kamran 2");
%>

<html>
<head>
</head>
<body>
	<h1><%=p.getName()%> 
		<%=number%></h1>
	<form method="post">
		<input type="hidden" name="n" value="<%=number%>" /> <input
			type="submit" value="Next" />
	</form>
</body>
</html>