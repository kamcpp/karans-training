<%@page import="co.karans.phonebook.web.domain.DefaultBookDAO"%>
<%@page import="co.karans.phonebook.web.domain.Book"%>
<%@page import="java.util.List"%>
<html>
<head>
</head>
<body>
	<a href="add-book.jsp">Create A New Book</a>
	<%
		List<Book> books = new DefaultBookDAO().getAll();
	%>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>
			<th>Publish Year</th>
		</tr>
		<% for(Book book : books) { %>
		<tr>
			<td><%= book.getId() %></td>
			<td><%= book.getName() %></td>
			<td><%= book.getAuthor() %></td>
			<td><%= book.getPublishYear() %></td>
		</tr>
		<% } %>
	</table>
	
</body>
</html>