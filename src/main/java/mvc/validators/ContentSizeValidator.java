package mvc.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContentSizeValidator implements ConstraintValidator<ContentSize, String> {

	private Integer min;
	private Integer max;
	
	public void initialize(ContentSize constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return ((value.length() >= min) && (value.length() <= max));
	}
	
	

}
