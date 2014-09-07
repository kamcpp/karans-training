<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="k" uri="WEB-INF/karans-tags.tld"%>
<%@page import="co.karans.phonebook.spring.MySpringContext"%>
<%@page import="co.karans.phonebook.web.domain.BookDAO"%>
<%@page import="co.karans.phonebook.web.domain.DefaultBookDAO"%>
<%@page import="co.karans.phonebook.web.domain.Book"%>
<%@page import="java.util.List"%>
<html>
<head>
</head>
<body>
	<a href="add-book.jsp">Create A New Book</a>
	<k:readBooks collection="books" />

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>
			<th>Publish Year</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.publishYear}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>