package example.web.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import example.web.validation.validator.EqualWithValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EqualWithValidator.class)
public @interface EqualWith {

	String field();
	
	String message() default "Should be equal.";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
