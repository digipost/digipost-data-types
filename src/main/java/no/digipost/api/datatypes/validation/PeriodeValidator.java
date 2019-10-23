package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.types.proof.Periode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeriodeValidator implements ConstraintValidator<ValidPeriode, Periode> {
    @Override
    public boolean isValid(Periode periode, ConstraintValidatorContext context) {
        return periode.getFra() != null || periode.getTil() != null;
    }
}
