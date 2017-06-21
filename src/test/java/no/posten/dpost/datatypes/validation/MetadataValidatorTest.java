package no.posten.dpost.datatypes.validation;

import no.posten.dpost.datatypes.types.Address;
import no.posten.dpost.datatypes.types.Appointment;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static co.unruly.matchers.Java8Matchers.where;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MetadataValidatorTest {

    private static MetadataValidator validator = new MetadataValidator();

    final Appointment appointment = new Appointment("What what", ZonedDateTime.now(ZoneId.of("GMT+02:00")).minusDays(5), new Address("Testgate 3", "0022", null),
        "Hey Macklemore. Let's go to a place we've never been before. The city? My memory doesn't point to any allocated address.", null);

    @Test
    public void testValidate() {
        final Set<MetadataValidationError<Appointment>> constraintViolations = validator.validate(appointment).collect(toSet());
        assertThat(constraintViolations, hasSize(1));
        assertThat(constraintViolations, Matchers.<MetadataValidationError<Appointment>>hasItem(where(MetadataValidationError::getPrettyMessage, is("The value for field 'Appointment.place.city' may not be null"))));
    }

    @Test
    public void testValidateOrThrow() {
        try {
            validator.validateOrThrow(appointment, errors -> new RuntimeException(errors.stream().map(MetadataValidationError::getPrettyMessage).collect(joining("\n"))));
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "The value for field 'Appointment.place.city' may not be null");
        }
    }

    @Test
    public void testValidateCollectionOrThrow() {
        try {
            validator.validateOrThrow(Collections.singleton(appointment), (Set<MetadataValidationError<Appointment>> errors) -> new RuntimeException(errors.stream().map(MetadataValidationError::getPrettyMessage).collect(joining("\n"))));
        } catch (RuntimeException e) {
            assertEquals(e.getMessage(), "The value for field 'Appointment.place.city' may not be null");
        }
    }

    @Test
    public void testValidateCollection() {
        final Stream<MetadataValidationError<Appointment>> errors = validator.validate(Collections.singleton(appointment));
        assertThat(errors.collect(toSet()), hasSize(1));
    }

    @Test
    public void testSuccessfulValidation() {
        validator.validateOrThrow(Appointment.EXAMPLE, __ -> new RuntimeException("Skulle ikke feilet"));
    }
}
