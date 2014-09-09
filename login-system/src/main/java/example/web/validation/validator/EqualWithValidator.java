package example.web.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import example.web.validation.annotation.EqualWith;

public class EqualWithValidator implements ConstraintValidator<EqualWith, String> {

	@Override
	public void initialize(EqualWith constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return true;
	}
	
	

}
