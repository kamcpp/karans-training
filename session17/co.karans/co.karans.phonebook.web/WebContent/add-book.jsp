<%@page import="co.karans.phonebook.web.domain.BookDAO"%>
<%@page import="co.karans.phonebook.web.domain.DefaultBookDAO"%>
<%@page import="co.karans.phonebook.web.domain.Book"%>
<jsp:useBean id="addBookFormBean"
	class="co.karans.phonebook.web.forms.AddBookForm"></jsp:useBean>
<jsp:setProperty property="*" name="addBookFormBean" />
<%
	if (request.getMethod().toUpperCase() == "POST") {
		
		Book book = new Book();
		book.setName(addBookFormBean.getName());
		book.setAuthor(addBookFormBean.getAuthor());
		book.setPublishYear(addBookFormBean.getPublishYear());
		
		BookDAO bookDao = new DefaultBookDAO();
		bookDao.save(book);
		response.sendRedirect("books.jsp");
	}
%>
<html>
	<head>
	</head>
	<body>
		<form method="post">
			Name <input type="text" name="name" value="" /> <br /> Author <input
				type="text" name="author" value=""> <br /> Publish Year <input
				type="text" name="publishYear" value=""> <br /> <input
				type="submit" value="Create Book" />
		</form>
	</body>
</html>