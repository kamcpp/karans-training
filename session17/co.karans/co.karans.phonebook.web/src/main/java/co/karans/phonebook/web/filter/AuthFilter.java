package co.karans.phonebook.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String url = request.getRequestURI() + "?" + request.getQueryString();
		System.out.println(url);
		if (url.contains("login.jsp")) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		boolean found = false;
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("token")) {
					found = true;
				}
			}
		}
		if (!found) {
			response.sendRedirect("login.jsp");
			return;
		}
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Authentication filter is initialized.");
	}
}
