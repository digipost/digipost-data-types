package no.digipost.api.datatypes.validation;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class DataTypesValidator {

    private final Validator validator;

    public DataTypesValidator(final Validator validator) {
        this.validator = validator;
    }

    public DataTypesValidator() {
        this(Validation.buildDefaultValidatorFactory().getValidator());
    }

    public <T> Stream<DataTypesValidationError<T>> validate(T object) {
        return validator.validate(object).stream().map(DataTypesValidationError::new);
    }

    public <T> Stream<DataTypesValidationError<T>> validate(Collection<T> object) {
        return object.stream().flatMap(this::validate);
    }

    public <T, U> Optional<U> validate(T object, Function<? super Set<DataTypesValidationError<T>>, U> onValidationError) {
        final Set<DataTypesValidationError<T>> errors = validate(object).collect(toSet());
        if (!errors.isEmpty()) {
            return Optional.of(onValidationError.apply(errors));
        } else {
            return Optional.empty();
        }
    }

    public <T, U> Optional<U> validate(Collection<T> object, Function<? super Set<DataTypesValidationError<T>>, U> onValidationError) {
        final Set<DataTypesValidationError<T>> errors = validate(object).collect(toSet());
        if (!errors.isEmpty()) {
            return Optional.of(onValidationError.apply(errors));
        } else {
            return Optional.empty();
        }
    }

    public <T, U extends Exception> void validateOrThrow(T object, Function<? super Set<DataTypesValidationError<T>>, U> onValidationError) throws U {
        final Optional<U> validate = validate(object, onValidationError);
        if (validate.isPresent()) {
            throw validate.get();
        }
    }

    public <T, U extends Exception> void validateOrThrow(Collection<T> object, Function<? super Set<DataTypesValidationError<T>>, U> onValidationError) throws U {
        final Optional<U> validate = validate(object, onValidationError);
        if (validate.isPresent()) {
            throw validate.get();
        }
    }
}
