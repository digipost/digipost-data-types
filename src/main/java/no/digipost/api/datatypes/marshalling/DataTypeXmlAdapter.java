package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.DataType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

public class DataTypeXmlAdapter extends XmlAdapter<Element, DataType> {
    private JAXBContext jaxbContext;
    private DocumentBuilder documentBuilder;

    public DataTypeXmlAdapter() {}

    public DataTypeXmlAdapter(JAXBContext jaxbContext) {
        this.jaxbContext = jaxbContext;
    }

    private JAXBContext getJAXBContext() throws JAXBException {
        if (jaxbContext == null) {
            jaxbContext = JAXBContext.newInstance("no.digipost.api.datatypes.types");
        }
        return jaxbContext;
    }

    private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        if(documentBuilder == null) {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        return documentBuilder;
    }

    @Override
    public DataType unmarshal(Element e) throws Exception {
        if(e == null) {
            return null;
        }

        DOMSource source = new DOMSource(e);
        Unmarshaller unmarshaller = getJAXBContext().createUnmarshaller();

        return (DataType) unmarshaller.unmarshal(source);
    }

    @Override
    public Element marshal(DataType dt) throws Exception {
        if (dt == null){
            return null;
        }

        QName qname = new QName(DataTypesJAXBContext.DIGIPOST_DATATYPES_NAMESPACE, dt.getType().toLowerCase());
        Class<?> type = dt.getClass();
        JAXBElement jaxbElement = new JAXBElement(qname, type, dt);

        Document document = getDocumentBuilder().newDocument();
        Marshaller marshaller = getJAXBContext().createMarshaller();
        marshaller.marshal(jaxbElement, document);

        return document.getDocumentElement();
    }
}
