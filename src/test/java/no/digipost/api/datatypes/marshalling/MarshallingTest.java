package no.digipost.api.datatypes.marshalling;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.DataTypeIdentifier;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MarshallingTest {

    @Test
    public void testJaxbMarshallingAllTypes() {
        Stream.of(DataTypeIdentifier.values())
                .map(DataTypeIdentifier::getExample)
                .forEach(this::testJaxbMarshalling);
    }

    @Test
    public void testJacksonJsonMarshallingAlltypes() {
        Stream.of(DataTypeIdentifier.values())
                .forEach(this::testJacksonJsonMarshalling);
    }

    public void testJacksonJsonMarshalling(DataTypeIdentifier example) {
        try {
            ObjectMapper mapper = DataTypesJsonMapper.getMapper();
            final String json = mapper.writer().writeValueAsString(example.getExample());
            final DataType unmarshalled = mapper.reader().forType(example.getDataType()).readValue(json);
            assertThat(unmarshalled, equalTo(example.getExample()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void testJaxbMarshalling(DataType example) {
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
