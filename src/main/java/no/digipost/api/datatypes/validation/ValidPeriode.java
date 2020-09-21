package no.digipost.api.datatypes.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PeriodeValidator.class)
@Documented
public @interface ValidPeriode {
    String message () default "At least one of the time periods from/to must be set.";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default {};
}
