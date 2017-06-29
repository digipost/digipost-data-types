package no.digipost.api.datatypes.marshalling;

import no.digipost.api.datatypes.DataType;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement
public class TestDocument {

    @XmlJavaTypeAdapter(DataTypeXmlAdapter.class)
    @XmlAnyElement
    @XmlElementWrapper(name="metadata")
    protected List<DataType> metadata;

    public TestDocument(List<DataType> metadata) {
        this.metadata = metadata;
    }

    TestDocument() {}
}
