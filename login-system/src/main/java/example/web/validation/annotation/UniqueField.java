package example.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import example.web.validation.validator.UniqueFieldValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueFieldValidator.class)
public @interface UniqueField {

	String targetField();

	String message() default "It is not unique.";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
