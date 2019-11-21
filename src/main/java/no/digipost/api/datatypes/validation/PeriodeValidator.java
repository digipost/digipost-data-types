package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.types.proof.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeriodeValidator implements ConstraintValidator<ValidPeriode, Period> {
    @Override
    public boolean isValid(Period periode, ConstraintValidatorContext context) {
        return periode.getFrom() != null || periode.getTo() != null;
    }
}
