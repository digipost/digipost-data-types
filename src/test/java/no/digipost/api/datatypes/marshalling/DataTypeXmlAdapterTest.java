package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.types.Appointment;
import no.digipost.api.datatypes.types.Residence;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class DataTypeXmlAdapterTest {

    private final DataTypeXmlAdapter adapter = new DataTypeXmlAdapter();

    @Test
    public void check_expected_marshalled_xmlstructure() throws Exception {
        DataType dt = Residence.EXAMPLE;
        String expectedXml = "<ns2:residence xmlns:ns2=\"http://api.digipost.no/schema/datatypes\">" +
                "<address><streetAddress>Storgata 23</streetAddress><postalCode>0011</postalCode><city>Oslo</city></address>" +
                "<source>boligmappa</source><externalId>externalId</externalId></ns2:residence>";
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
    }
}
