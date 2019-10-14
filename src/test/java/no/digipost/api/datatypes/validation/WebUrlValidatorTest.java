package no.digipost.api.datatypes.validation;

import no.digipost.api.datatypes.types.ExternalLink;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class WebUrlValidatorTest {

    private static DataTypesValidator validator = new DataTypesValidator();

    @Test
    void testValidUrls() {
        List<ExternalLink> links = Arrays.asList(
                ExternalLink.EXAMPLE,
                ExternalLink.EXAMPLE.withUrl(URI.create("http://example.com"))
        );

        assertThat(validator.validate(links).collect(toList()), empty());
    }

    @Test
    void testInvalidUrls() {
        List<ExternalLink> links = Arrays.asList(
                ExternalLink.EXAMPLE.withUrl(URI.create("ftp://example.com")),
                ExternalLink.EXAMPLE.withUrl(URI.create("example.com")),
                ExternalLink.EXAMPLE.withUrl(URI.create("mailto:example.com"))
        );

        final List<DataTypesValidationError<ExternalLink>> results = validator.validate(links).collect(toList());
        assertThat(results, hasSize(3));
        assertThat(results.get(0).getConstraintViolation().getMessage(), is("URL scheme must be http or https"));
    }
}
