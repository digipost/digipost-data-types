package no.posten.dpost.datatypes.marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class MetadataJAXBContext {

    public static final String DIGIPOST_DATATYPES_NAMESPACE = "http://api.digipost.no/schema/datatypes";
    public static final String DATATYPES_XSD_FILENAME = "datatypes.xsd";
    public static final String DATATYPES_JAXB_CONTEXT_PATH = "no.posten.dpost.datatypes.types";

    private final JAXBContext context;

    public MetadataJAXBContext(final JAXBContext context) {
        this.context = context;
    }

    public MetadataJAXBContext() throws JAXBException {
        this(JAXBContext.newInstance(DATATYPES_JAXB_CONTEXT_PATH));
    }

    public JAXBContext getContext() {
        return context;
    }

}
