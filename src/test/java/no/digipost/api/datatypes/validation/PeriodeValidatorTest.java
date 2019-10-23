package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.types.proof.Periode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PeriodeValidatorTest {

    private static DataTypesValidator validator = new DataTypesValidator();

    @Test
    void testValidPerioder() {
        List<Periode> periodes = Arrays.asList(
                Periode.EXAMPLE,
                Periode.EXAMPLE.withFra(null),
                Periode.EXAMPLE.withTil(null)
        );

        assertThat(validator.validate(periodes).collect(toList()), empty());
    }

    @Test
    void testInvalidPerioder() {
        Periode invalid = Periode.EXAMPLE.withFra(null).withTil(null);

        final List<DataTypesValidationError<Periode>> result = validator.validate(invalid).collect(toList());
        assertThat(result, hasSize(1));
        assertThat(result.get(0).getConstraintViolation().getMessage(), is("At least one of the time periods from/to must be set."));
    }
}
