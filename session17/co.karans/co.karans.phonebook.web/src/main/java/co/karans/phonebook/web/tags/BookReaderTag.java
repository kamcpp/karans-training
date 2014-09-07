package co.karans.phonebook.web.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import co.karans.phonebook.spring.MySpringContext;
import co.karans.phonebook.web.domain.Book;
import co.karans.phonebook.web.domain.BookDAO;

public class BookReaderTag extends SimpleTagSupport {

	private String collection;

	public void setCollection(String collection) {
		this.collection = collection;
	}

	@Override
	public void doTag() throws JspException, IOException {
		BookDAO bookDao = MySpringContext.getContext().getBean(BookDAO.class);
		List<Book> books = bookDao.getAll();
		getJspContext().setAttribute(collection, books);
	}
}
