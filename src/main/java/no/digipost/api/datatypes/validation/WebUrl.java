package no.digipost.api.datatypes.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = WebUrlValidator.class)
@Documented
public @interface WebUrl {

    String message() default "URL scheme must be http or https";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
