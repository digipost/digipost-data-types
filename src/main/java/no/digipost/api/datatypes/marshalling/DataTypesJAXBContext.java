package no.digipost.api.datatypes.marshalling;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class DataTypesJAXBContext {

    public static final String DIGIPOST_DATATYPES_NAMESPACE = "http://api.digipost.no/schema/datatypes";
    public static final String DATATYPES_XSD_FILENAME = "datatypes.xsd";
    public static final String DATATYPES_JAXB_CONTEXT_PATH = "no.digipost.api.datatypes.types";

    private static class Singleton {
        private static final JAXBContext jaxbContext;

        static {
            try {
                jaxbContext = JAXBContext.newInstance(DATATYPES_JAXB_CONTEXT_PATH);
            } catch (JAXBException e) {
                throw new RuntimeException("Unable to instationate jaxb context for Digipost DataTypes", e);
            }
        }
    }

    public static JAXBContext getSingleton() {
        return Singleton.jaxbContext;
    }
}
