package no.digipost.api.datatypes.types;

import no.digipost.api.datatypes.DataTypeIdentifier;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class JAXBIndexTest {

    @Test
    void check_all_metatdata_in_jaxb_index() throws IOException, URISyntaxException {
        final List<String> classNames = Files.readAllLines(Paths.get(getClass().getResource("jaxb.index").toURI()), UTF_8);
        assertThat("Alle datatyper må ligge i jaxb.index for at de skal fungere med JAXB", classNames, containsInAnyOrder(Stream.of(DataTypeIdentifier.values())
                .map(DataTypeIdentifier::getDataType)
                .map(Class::getName)
                .map(n -> n.replaceAll("no.digipost.api.datatypes.types.", "")).toArray()));
    }
}
