package com.rays.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityValidator.class)
public @interface ValidPriority {
	String message() default "Priority should be one of: Open, Close, Hold";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}

class PriorityValidator implements ConstraintValidator<ValidPriority, String> {

	@Override
	public void initialize(ValidPriority constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		try {
			PriorityType.valueOf(value); // This will throw IllegalArgumentException if value is not in enum
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}
}

enum PriorityType {
	Open, Close, Hold
}
