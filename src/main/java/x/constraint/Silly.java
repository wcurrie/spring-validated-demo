package x.constraint;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=SillyValidator.class)
public @interface Silly {
    String message() default "Totally daft";
    Class[] groups() default {};
    Class[] payload() default {};
}
