package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.DataTypeIdentifier;
import no.digipost.api.datatypes.types.Address;
import no.digipost.api.datatypes.types.Appointment;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static co.unruly.matchers.Java8Matchers.where;
import static java.util.Collections.singleton;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DataTypesValidatorTest {

    private static final DataTypesValidator validator = new DataTypesValidator();

    private final Appointment appointment = Appointment.EXAMPLE.withAddress(new Address("Storgata 2", null,"00000000001", "Oslo", null));
    private final String error = "The value for field 'Appointment.address.postalCode' size must be between 0 and 10. The invalid value was '00000000001'";

    @Test
    void testValidate() {
        final Set<DataTypesValidationError<Appointment>> constraintViolations = validator.validate(appointment).collect(toSet());
        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations, Matchers.<DataTypesValidationError<Appointment>>hasItem(where(DataTypesValidationError::getPrettyMessage, is(error))));
    }

    @Test
    void testValidateOrThrow() {
        RuntimeException thrown = assertThrows(RuntimeException.class, () ->
            validator.validateOrThrow(appointment, (Set<DataTypesValidationError<Appointment>> errors) -> new RuntimeException(errors.stream().map(DataTypesValidationError::getPrettyMessage).collect(joining("\n")))));
        assertThat(thrown, where(Exception::getMessage, is(error)));
    }

    @Test
    void testValidateCollectionOrThrow() {
        RuntimeException thrown = assertThrows(RuntimeException.class, () ->
                validator.validateOrThrow(singleton(appointment), (Set<DataTypesValidationError<Appointment>> errors) -> new RuntimeException(errors.stream().map(DataTypesValidationError::getPrettyMessage).collect(joining("\n")))));
        assertThat(thrown, where(Exception::getMessage, is(error)));
    }

    @Test
    void testValidateCollection() {
        final Stream<DataTypesValidationError<Appointment>> errors = validator.validate(Collections.singleton(appointment));
        assertThat(errors.collect(toSet()), hasSize(1));
    }

    @Test
    void testSuccessfulValidation() {
        validator.validateOrThrow(Appointment.EXAMPLE, __ -> new RuntimeException("Skulle ikke feilet"));
    }

    @Test
    void testValidationOfAllExamples() {
        final Stream<DataTypesValidationError<DataType>> results =
                Stream.of(DataTypeIdentifier.values())
                        .map(DataTypeIdentifier::getExample)
                        .flatMap(validator::validate);
        assertThat(results.collect(toList()), is(empty()));
    }
}
