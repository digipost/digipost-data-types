package no.digipost.api.datatypes.marshalling;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.digipost.api.datatypes.types.Appointment;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MarshallingTest {

    final Appointment appointment = Appointment.EXAMPLE;

    @Test
    public void testJaxbMarshalling() throws JAXBException {
        final JAXBContext jaxbContext = DataTypesJAXBContext.getSingleton();
        final Marshaller marshaller = jaxbContext.createMarshaller();
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        final StringWriter writer = new StringWriter();
        marshaller.marshal(appointment, writer);
        final Appointment unmarshalled = (Appointment) unmarshaller.unmarshal(new StringReader(writer.toString()));
        assertThat(unmarshalled, equalTo(appointment));
    }

    @Test
    public void testJacksonJsonMarshalling() throws IOException {
        ObjectMapper mapper = DataTypesJsonMapper.getMapper();
        final String json = mapper.writer().writeValueAsString(appointment);
        final Appointment unmarshalled = mapper.reader().forType(Appointment.class).readValue(json);
        assertThat(unmarshalled, equalTo(appointment));
    }
}
