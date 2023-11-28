package no.digipost.api.datatypes.marshalling;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.DataTypeIdentifier;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MarshallingTest {

    @Test
    void testJaxbMarshallingAllTypes() {
        Stream.of(DataTypeIdentifier.values())
                .map(DataTypeIdentifier::getExample)
                .forEach(MarshallingTest::testJaxbMarshalling);
    }

    @Test
    void testJacksonJsonMarshallingAlltypes() {
        Stream.of(DataTypeIdentifier.values())
                .forEach(MarshallingTest::testJacksonJsonMarshalling);
    }

    static void testJacksonJsonMarshalling(DataTypeIdentifier example) {
        try {
            ObjectMapper mapper = DataTypesJsonMapper.getMapper();
            final String json = mapper.writer().writeValueAsString(example.getExample());
            final DataType unmarshalled = mapper.reader().forType(example.getDataType()).readValue(json);
            assertThat(unmarshalled, equalTo(example.getExample()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void testJaxbMarshalling(DataType example) {
        try {
            final JAXBContext jaxbContext = DataTypesJAXBContext.getSingleton();
            final Marshaller marshaller = jaxbContext.createMarshaller();
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            final StringWriter writer = new StringWriter();
            marshaller.marshal(example, writer);
            final DataType unmarshalled = (DataType) unmarshaller.unmarshal(new StringReader(writer.toString()));
            assertThat(unmarshalled, equalTo(example));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
