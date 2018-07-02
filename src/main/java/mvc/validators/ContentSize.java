package mvc.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = ContentSizeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentSize {

	int min() default 12;
	int max() default 50;
	
	String message() default "{ContentSize.error.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
