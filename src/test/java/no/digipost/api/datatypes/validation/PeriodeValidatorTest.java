package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.types.proof.Period;
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
        List<Period> periodes = Arrays.asList(
                Period.EXAMPLE,
                Period.EXAMPLE.withFrom(null),
                Period.EXAMPLE.withTo(null)
        );

        assertThat(validator.validate(periodes).collect(toList()), empty());
    }

    @Test
    void testInvalidPerioder() {
        Period invalid = Period.EXAMPLE.withFrom(null).withTo(null);

        final List<DataTypesValidationError<Period>> result = validator.validate(invalid).collect(toList());
        assertThat(result, hasSize(1));
        assertThat(result.get(0).getConstraintViolation().getMessage(), is("At least one of the time periods from/to must be set."));
    }
}
