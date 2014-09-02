<%
	String nField = request.getParameter("n");
	int number = 0;
	if (nField != null) {
		number = Integer.parseInt(nField);
	}
	number++;
%>
<h1><%=number%></h1>

<a href="qs.jsp?n=<%=number%>">Next</a>