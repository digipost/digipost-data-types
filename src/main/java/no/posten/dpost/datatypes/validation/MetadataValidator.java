package no.posten.dpost.datatypes.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@Component
public class MetadataValidator {

    private final Validator validator;

    @Autowired
    public MetadataValidator(final Validator validator) {
        this.validator = validator;
    }

    public MetadataValidator() {
        this(Validation.buildDefaultValidatorFactory().getValidator());
    }

    public <T> Stream<MetadataValidationError<T>> validate(T object) {
        return validator.validate(object).stream().map(MetadataValidationError::new);
    }

    public <T> Stream<MetadataValidationError<T>> validate(Collection<T> object) {
        return object.stream().flatMap(this::validate);
    }

    public <T, U> Optional<U> validate(T object, Function<? super Set<MetadataValidationError<T>>, U> onValidationError) {
        final Set<MetadataValidationError<T>> errors = validate(object).collect(toSet());
        if (!errors.isEmpty()) {
            return Optional.of(onValidationError.apply(errors));
        } else {
            return Optional.empty();
        }
    }

    public <T, U> Optional<U> validate(Collection<T> object, Function<? super Set<MetadataValidationError<T>>, U> onValidationError) {
        final Set<MetadataValidationError<T>> errors = validate(object).collect(toSet());
        if (!errors.isEmpty()) {
            return Optional.of(onValidationError.apply(errors));
        } else {
            return Optional.empty();
        }
    }

    public <T, U extends Exception> void validateOrThrow(T object, Function<? super Set<MetadataValidationError<T>>, U> onValidationError) throws U {
        final Optional<U> validate = validate(object, onValidationError);
        if (validate.isPresent()) {
            throw validate.get();
        }
    }

    public <T, U extends Exception> void validateOrThrow(Collection<T> object, Function<? super Set<MetadataValidationError<T>>, U> onValidationError) throws U {
        final Optional<U> validate = validate(object, onValidationError);
        if (validate.isPresent()) {
            throw validate.get();
        }
    }
}
