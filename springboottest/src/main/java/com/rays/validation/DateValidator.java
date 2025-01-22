package com.rays.validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, String> {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @Override
    public void initialize(ValidDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        if (dateStr == null) {
            return true; // @NotNull handle karega null case ko
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false);
        try {
            Date inputDate = sdf.parse(dateStr);
            Date currentDate = new Date(); // Vartaman tithi

            // Agar inputDate future date hai toh error generate karein
            if (inputDate.after(currentDate)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("Future dates are not allowed")
                       .addConstraintViolation();
                return false;
            }

            return true;
        } catch (ParseException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Invalid date format, please use " + DATE_FORMAT)
                   .addConstraintViolation();
            return false;
        }
    }
}
