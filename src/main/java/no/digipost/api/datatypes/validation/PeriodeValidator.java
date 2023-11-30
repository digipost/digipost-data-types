package no.digipost.api.datatypes.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import no.digipost.api.datatypes.types.proof.Period;

public class PeriodeValidator implements ConstraintValidator<ValidPeriode, Period> {
    @Override
    public boolean isValid(Period periode, ConstraintValidatorContext context) {
        return periode.getFrom() != null || periode.getTo() != null;
    }
}
