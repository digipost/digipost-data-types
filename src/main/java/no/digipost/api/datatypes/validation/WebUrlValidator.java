package no.digipost.api.datatypes.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.net.URI;

public class WebUrlValidator implements ConstraintValidator<WebUrl, URI> {
    @Override
    public void initialize(WebUrl constraintAnnotation) {

    }

    @Override
    public boolean isValid(URI value, ConstraintValidatorContext context) {
        final String scheme = value.getScheme();
        return scheme != null &&
                (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"));
    }
}
