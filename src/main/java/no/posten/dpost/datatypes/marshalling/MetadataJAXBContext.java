package no.posten.dpost.datatypes.marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class MetadataJAXBContext {

    public static final String DIGIPOST_METADATA_NAMESPACE = "http://api.digipost.no/schema/metadata";
    public static final String METADATA_XSD_FILENAME = "metadata.xsd";
    public static final String METADATA_JAXB_CONTEXT_PATH = "no.posten.dpost.metadata.types";

    private final JAXBContext context;

    public MetadataJAXBContext(final JAXBContext context) {
        this.context = context;
    }

    public MetadataJAXBContext() throws JAXBException {
        this(JAXBContext.newInstance(METADATA_JAXB_CONTEXT_PATH));
    }

    public JAXBContext getContext() {
        return context;
    }

}
