package x.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodValidator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Set;

@Aspect
public class HackValidationAspect {
    private final transient Validator validator = Validation
            .buildDefaultValidatorFactory()
            .getValidator();

    @Before("execution(* *(.., @(javax.validation.* || javax.validation.constraints.*) (*), ..))")
    public void beforeMethod(final JoinPoint point) {
        MethodValidator methodValidator = validator.unwrap(MethodValidator.class);
        Set<MethodConstraintViolation<Object>> violations = methodValidator.validateAllParameters(
                point.getThis(),
                MethodSignature.class.cast(point.getSignature()).getMethod(),
                point.getArgs()
        );
        checkForViolations(violations);
    }

    private void checkForViolations(
            final Set<? extends ConstraintViolation<Object>> violations) {
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(
                    pack(violations),
                    (Set<ConstraintViolation<?>>) violations
            );
        }
    }

    /**
     * Pack violations into string.
     * @param errs All violations
     * @return The full text
     */
    private static String pack(
            final Collection<? extends ConstraintViolation<Object>> errs) {
        final StringBuilder text = new StringBuilder(0);
        for (final ConstraintViolation<?> violation : errs) {
            if (text.length() > 0) {
                text.append("; ");
            }
            text.append(violation.getMessage());
        }
        return text.toString();
    }
}
