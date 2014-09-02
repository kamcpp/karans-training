package karans.s16.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KaransMvcServlet extends HttpServlet {

	private static final long serialVersionUID = 8336019946360651522L;

	private String basePackage;

	@Override
	public void init(ServletConfig config) throws ServletException {
		basePackage = config.getServletContext()
				.getInitParameter("basePackage");
		System.out.println(basePackage);
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] tokens = request.getRequestURI().split("/");
		String[] parts = tokens[tokens.length - 1].split("-");

		String controllerClass = basePackage + "." + parts[0] + "Controller";
		String controllerMethod = parts[1];
		Double op1 = Double.parseDouble(parts[2]);
		Double op2 = Double.parseDouble(parts[3]);

		PrintWriter pw = new PrintWriter(response.getOutputStream());

		try {
			Class<?> clazz = Class.forName(controllerClass);
			Object controller = clazz.newInstance();
			Method method = clazz.getMethod(controllerMethod, new Class<?>[] {
					Double.class, Double.class });
			Object result = method
					.invoke(controller, new Object[] { op1, op2 });
			response.setStatus(200);
			pw.print(result);
			pw.flush();
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(404);
			pw.print("<h1>Karans MVC said: 404 Not Found</h1>");
		} finally {
			try {
				pw.close();
			} catch (Exception e) {
			}
		}
	}
}
