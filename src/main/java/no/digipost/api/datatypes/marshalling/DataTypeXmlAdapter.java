package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.DataType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;

public class DataTypeXmlAdapter extends XmlAdapter<Object, DataType> {

    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    @Override
    public DataType unmarshal(Object e) throws Exception {
        if(e == null) {
            return null;
        }
        DOMSource source = new DOMSource((Element) e);
        Unmarshaller unmarshaller = DataTypesJAXBContext.getSingleton().createUnmarshaller();
        return (DataType) unmarshaller.unmarshal(source);
    }

    @Override
    public Element marshal(DataType dt) throws Exception {
        if (dt == null){
            return null;
        }
        Document document = documentBuilderFactory.newDocumentBuilder().newDocument();
        Marshaller marshaller = DataTypesJAXBContext.getSingleton().createMarshaller();
        marshaller.marshal(dt, document);
        return document.getDocumentElement();
    }
}
