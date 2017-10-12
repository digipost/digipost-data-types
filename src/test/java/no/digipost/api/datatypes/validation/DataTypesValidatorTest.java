package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.DataTypeIdentifier;
import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.AppointmentAddress;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static co.unruly.matchers.Java8Matchers.where;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DataTypesValidatorTest {

    private static DataTypesValidator validator = new DataTypesValidator();

    final Appointment appointment = Appointment.EXAMPLE.withAddress(new AppointmentAddress("Storgata 2", "0001", null));

    @Test
    public void testValidate() {
        final Set<DataTypesValidationError<Appointment>> constraintViolations = validator.validate(appointment).collect(toSet());
        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations, Matchers.<DataTypesValidationError<Appointment>>hasItem(where(DataTypesValidationError::getPrettyMessage, is("The value for field 'Appointment.address.city' may not be null"))));
    }

    @Test
    public void testValidateOrThrow() {
        try {
            validator.validateOrThrow(appointment, (Set<DataTypesValidationError<Appointment>> errors) -> new RuntimeException(errors.stream().map(DataTypesValidationError::getPrettyMessage).collect(joining("\n"))));
        } catch (RuntimeException e) {
            assertEquals("The value for field 'Appointment.address.city' may not be null", e.getMessage());
        }
    }

    @Test
    public void testValidateCollectionOrThrow() {
        try {
            validator.validateOrThrow(Collections.singleton(appointment), (Set<DataTypesValidationError<Appointment>> errors) -> new RuntimeException(errors.stream().map(DataTypesValidationError::getPrettyMessage).collect(joining("\n"))));
        } catch (RuntimeException e) {
            assertEquals("The value for field 'Appointment.address.city' may not be null", e.getMessage());
        }
    }

    @Test
    public void testValidateCollection() {
        final Stream<DataTypesValidationError<Appointment>> errors = validator.validate(Collections.singleton(appointment));
        assertThat(errors.collect(toSet()), hasSize(1));
    }

    @Test
    public void testSuccessfulValidation() {
        validator.validateOrThrow(Appointment.EXAMPLE, __ -> new RuntimeException("Skulle ikke feilet"));
    }

    @Test
    public void testValidationOfAllExamples() {
        final Stream<DataTypesValidationError<DataType>> results =
                Stream.of(DataTypeIdentifier.values())
                        .map(DataTypeIdentifier::getExample)
                        .flatMap(validator::validate);
        assertThat(results.collect(toList()), is(empty()));
    }
}
