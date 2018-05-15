package no.digipost.api.datatypes.types;

import no.digipost.api.datatypes.DataTypeIdentifier;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class JAXBIndexTest {

    @Test
    public void check_all_metatdata_in_jaxb_index() throws IOException {
        final List<String> classNames = readLines(getClass().getResource("jaxb.index"), UTF_8);
        assertThat("Alle datatyper må ligge i jaxb.index for at de skal fungere med JAXB", classNames, containsInAnyOrder(Stream.of(DataTypeIdentifier.values())
                .map(DataTypeIdentifier::getDataType)
                .map(Class::getName)
                .map(n -> n.replaceAll("no.digipost.api.datatypes.types.", "")).toArray()));
    }
}
