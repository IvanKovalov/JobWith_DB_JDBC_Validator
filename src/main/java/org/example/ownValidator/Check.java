package org.example.ownValidator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;


@Documented
@Constraint(validatedBy = CheckSymbol.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    String message() default "Invalid count of vowel symbol";

    Class<?>[] groups() default {};
    int value();
    Class<? extends Payload>[] payload() default {};
}

