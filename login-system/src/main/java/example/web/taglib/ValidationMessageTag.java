package example.web.taglib;

import java.io.IOException;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;

public class ValidationMessageTag extends SimpleTagSupport {

	Logger logger = Logger.getLogger(ValidationMessageTag.class);

	private String field;

	public void setField(String field) {
		this.field = field;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void doTag() throws JspException, IOException {
		Set<ConstraintViolation<Object>> violations = (Set<ConstraintViolation<Object>>) getJspContext()
				.getAttribute("violations");
		for (ConstraintViolation<Object> violation : violations) {
			if (violation.getPropertyPath().toString().equals(field)) {
				logger.trace("ERROR ---> '" + violation.getPropertyPath() + "', field: '" + field + "'");
				JspWriter out = getJspContext().getOut();
				out.write("<span style='color: red'>" + violation.getMessage()
						+ "</span>");
				out.flush();
				break;
			}
		}
	}
}
