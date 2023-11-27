package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.Residence;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataTypeXmlAdapterTest {

    private final DataTypeXmlAdapter adapter = new DataTypeXmlAdapter();

    DataTypeXmlAdapterTest() throws JAXBException {
    }

    @Test
    void check_expected_marshalled_xmlstructure() throws Exception {
        DataType dt = Residence.EXAMPLE;
        String expectedXml = "<residence xmlns=\"http://api.digipost.no/schema/datatypes\">" +
                "<address><house-number>23</house-number><street-name>Storgata</street-name><postal-code>0011</postal-code><city>Oslo</city></address>" +
                "<matrikkel><kommunenummer>0301</kommunenummer><gaardsnummer>208</gaardsnummer><bruksnummer>630</bruksnummer><festenummer>0</festenummer><seksjonsnummer>0</seksjonsnummer></matrikkel>" +
                "<source>boligmappa</source><external-id>externalId</external-id></residence>";
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(adapter.marshal(dt)), new StreamResult(writer));
        String newXml = writer.toString();
        assertEquals(expectedXml, newXml);
    }

    @Test
    void check_expected_unmarshalled_javaobject() throws Exception {
        DataType originalDt = Residence.EXAMPLE;
        Element newElement = adapter.marshal(originalDt);
        DataType resultDt = adapter.unmarshal(newElement);

        assertEquals(originalDt, resultDt);

        DataType originalDt2 = Appointment.EXAMPLE;
        Element newElement2 = adapter.marshal(originalDt2);
        DataType resultDt2 = adapter.unmarshal(newElement2);

        assertEquals(originalDt2, resultDt2);

        DataType originalDt3 = Residence.EXAMPLE;
        Element newElement3 = adapter.marshal(originalDt3);
        DataType resultDt3 = adapter.unmarshal(newElement3);

        assertEquals(originalDt3, resultDt3);
    }

    @Test
    void test_usage_as_part_of_other_jaxb_context() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TestDocument.class);
        final StringWriter writer = new StringWriter();
        jaxbContext.createMarshaller().marshal(new TestDocument(singletonList(Appointment.EXAMPLE)), writer);
        assertThat(writer.toString(), containsString("appointment"));
    }
}
