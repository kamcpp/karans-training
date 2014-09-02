
<%
	String result = request.getParameter("r");
	boolean weHaveResultsToPrint = result != null;
	String operand1 = request.getParameter("a");
	String operand2 = request.getParameter("b");
%>
<!doctype html>
<html>
<head>
</head>
<body>
	<form action="do-calculation.jsp" method="post">
		Operand 1 <input type="text" name="operand1" value="<%= operand1 == null? "" : operand1  %>" /><br />
		Operand 2 <input type="text" name="operand2" value="<%= operand2 == null? "" : operand2  %>" /><br />
		<% if(weHaveResultsToPrint) { %>
		  Output is <h5 style='color: green; display: inline;'><%= result %></h5><br />
		<% } %>
		Operation <select name="operation">
			<option value="none" selected>---</option>
			<option value="add">Addition</option>
			<option value="multiply">Multiplication</option>
		</select><br /> <input type="submit" value="Calculate" />
	</form>
</body>
</html>