package no.digipost.api.datatypes.documentation;

import no.digipost.api.datatypes.types.Addition;
import no.digipost.api.datatypes.types.MetaData;
import no.digipost.api.datatypes.types.ShortTextMessage;
import org.junit.jupiter.api.Test;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;

class DocumentationTest {

    @Test
    void should_build_type_structure_for_test_data_type() {
        Stream<ComplexType> types = DocumentationStructureBuilder
                .buildTypeStructure(singleton(ShortTextMessage.class), t -> ShortTextMessage.EXAMPLE);

        assertThat(types.collect(toSet()), contains(
                new ComplexType(ShortTextMessage.class, "150 character short message",
                        Arrays.asList(
                                new FieldInfo("message", new SimpleType(String.class), true, "Your short message goes here"),
                                new FieldInfo("metaData",
                                        new ComplexType(
                                                MetaData.class
                                                , "Metainformation"
                                                , Collections.singletonList(new FieldInfo("value", new SimpleType(String.class), true, "Your extra information"))
                                                , null, Collections.emptyList()), false, "Some metadata for shortTextMessage")
                        ),
                        ShortTextMessage.EXAMPLE, singletonList(new ComplexType(Addition.class, null, null, null, Collections.emptyList())))));
    }

    @Test
    void should_print_docs_for_test_data_type() throws IOException, JAXBException, URISyntaxException {
        String docs = new MarkdownPrinter(JAXBContext.newInstance(ShortTextMessage.class), true)
                .print(DocumentationStructureBuilder
                        .buildTypeStructure(singleton(ShortTextMessage.class), t -> ShortTextMessage.EXAMPLE)
                        .collect(toList()));

        assertThat(docs, is(new String(Files.readAllBytes(Paths.get(getClass().getResource("testdoc.md").toURI())), UTF_8)));
    }
}
