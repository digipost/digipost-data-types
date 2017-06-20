package no.posten.dpost.metadata.validation;

import lombok.Value;

import javax.validation.ConstraintViolation;

@Value
public class MetadataValidationError<T> {
    ConstraintViolation<T> constraintViolation;

    public String getPrettyMessage() {
        final String baseMessage = String.format("The value for field '%s.%s' %s",
            constraintViolation.getRootBeanClass().getSimpleName(),
            constraintViolation.getPropertyPath(),
            constraintViolation.getMessage());
        if (constraintViolation.getInvalidValue() != null) {
            return baseMessage + ". The invalid value was '" + constraintViolation.getInvalidValue() + "'";
        } else {
            return baseMessage;
        }
    }
}
