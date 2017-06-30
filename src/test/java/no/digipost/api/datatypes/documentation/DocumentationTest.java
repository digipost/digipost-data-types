package no.digipost.api.datatypes.documentation;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.types.ShortTextMessage;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collections;
import java.util.stream.Stream;

import static com.google.common.io.Resources.toByteArray;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.singleton;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DocumentationTest {

    @Test
    public void should_build_type_structure_for_test_data_type() {
        final Stream<ComplexType> types = DocumentationStructureBuilder.<DataType>buildTypeStructure(
            singleton(ShortTextMessage.class), t -> ShortTextMessage.EXAMPLE);
        assertThat(types.collect(toSet()), contains(
            new ComplexType(ShortTextMessage.class, "150 character short message",
                    Collections.singletonList(new FieldInfo("message", new SimpleType(String.class), true, "Your short message goes here")),
                    ShortTextMessage.EXAMPLE)));
    }

    @Test
    public void should_print_docs_for_test_data_type() throws IOException, JAXBException {
        final String docs = new MarkdownPrinter(JAXBContext.newInstance(ShortTextMessage.class), true).print(DocumentationStructureBuilder.<DataType>buildTypeStructure(
            singleton(ShortTextMessage.class), t -> ShortTextMessage.EXAMPLE).collect(toList()));

        assertThat(docs, is(new String(toByteArray(getClass().getResource("testdoc.md")), UTF_8)));
    }
}
