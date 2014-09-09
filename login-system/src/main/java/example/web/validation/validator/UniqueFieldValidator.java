package example.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import example.web.validation.annotation.UniqueField;

public class UniqueFieldValidator implements
		ConstraintValidator<UniqueField, String> {

	@Override
	public void initialize(UniqueField constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
