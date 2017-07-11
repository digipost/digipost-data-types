package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.Category;
import no.digipost.api.datatypes.types.Residence;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
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
import static org.junit.Assert.assertThat;

public class DataTypeXmlAdapterTest {

    private final DataTypeXmlAdapter adapter = new DataTypeXmlAdapter();

    public DataTypeXmlAdapterTest() throws JAXBException {
    }

    @Test
    public void check_expected_marshalled_xmlstructure() throws Exception {
        DataType dt = Residence.EXAMPLE;
        String expectedXml = "<ns2:residence xmlns:ns2=\"http://api.digipost.no/schema/datatypes\">" +
                "<address><street-address>Storgata 23</street-address><postal-code>0011</postal-code><city>Oslo</city></address>" +
                "<source>boligmappa</source><external-id>externalId</external-id></ns2:residence>";
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(adapter.marshal(dt)), new StreamResult(writer));
        String newXml = writer.toString();
        Assert.assertEquals(expectedXml, newXml);
    }

    @Test
    public void check_expected_marshalled_xmlstructureForEnum() throws Exception {
        DataType dt = Category.EXAMPLE;
        String expectedXml = "<ns2:category xmlns:ns2=\"http://api.digipost.no/schema/datatypes\">EXAMPLE</ns2:category>";
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(adapter.marshal(dt)), new StreamResult(writer));
        String newXml = writer.toString();
        Assert.assertEquals(expectedXml, newXml);
    }

    @Test
    public void check_expected_unmarshalled_javaobject() throws Exception {
        DataType originalDt = Residence.EXAMPLE;
        Element newElement = adapter.marshal(originalDt);
        DataType resultDt = adapter.unmarshal(newElement);

        Assert.assertEquals(originalDt, resultDt);

        DataType originalDt2 = Appointment.EXAMPLE;
        Element newElement2 = adapter.marshal(originalDt2);
        DataType resultDt2 = adapter.unmarshal(newElement2);

        Assert.assertEquals(originalDt2, resultDt2);

        DataType originalDt3 = Category.RESIDENCE;
        Element newElement3 = adapter.marshal(originalDt3);
        DataType resultDt3 = adapter.unmarshal(newElement3);

        Assert.assertEquals(originalDt3, resultDt3);
    }

    @Test
    public void test_usage_as_part_of_other_jaxb_context() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(TestDocument.class);
        final StringWriter writer = new StringWriter();
        jaxbContext.createMarshaller().marshal(new TestDocument(singletonList(Appointment.EXAMPLE)), writer);
        assertThat(writer.toString(), Matchers.containsString("appointment"));
    }
}
