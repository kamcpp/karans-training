package example.web.taglib;

import java.io.IOException;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class KaransValidateTag extends SimpleTagSupport {

	private String bean;

	public void setBean(String bean) {
		this.bean = bean;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Validator validator = Validation.buildDefaultValidatorFactory()
				.getValidator();
		Object toBeValidated = getJspContext().getAttribute(bean);
		Set<ConstraintViolation<Object>> violations = validator
				.validate(toBeValidated);
		getJspContext().setAttribute("violations", violations);
	}
}
