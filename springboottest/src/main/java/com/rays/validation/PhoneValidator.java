package com.rays.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<ValidPhone, Long> {

    @Override
    public void initialize(ValidPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long phone, ConstraintValidatorContext context) {
        if (phone == null) {
            return false;
        }
        // Validate phone number format
        String phoneString = String.valueOf(phone);
        return phoneString.matches("^([6-9]\\d{0,9}|[1-9]\\d{9})$");

    }
}
