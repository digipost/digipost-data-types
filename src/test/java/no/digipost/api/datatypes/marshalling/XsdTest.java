package no.digipost.api.datatypes.marshalling;

import org.junit.jupiter.api.Test;

import static no.digipost.api.datatypes.marshalling.DataTypesJAXBContext.DATATYPES_XSD_FILENAME;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class XsdTest {
    @Test
    void generatedXsdShouldBeOnClasspath() {
        assertNotNull(getClass().getClassLoader().getResourceAsStream(DATATYPES_XSD_FILENAME));
    }
}
