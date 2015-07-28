package x.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SillyValidator implements ConstraintValidator<Silly, String> {
    @Override
    public void initialize(Silly constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // only here to set a breakpoint and understand the call stack for validation
        System.out.println("SillyValidator value = " + value);
        return false;
    }
}
