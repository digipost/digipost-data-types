package no.digipost.api.datatypes.marshalling;

import org.junit.Test;

import static no.digipost.api.datatypes.marshalling.DataTypesJAXBContext.DATATYPES_XSD_FILENAME;
import static org.junit.Assert.assertNotNull;

public class XsdTest {
    @Test
    public void generatedXsdShouldBeOnClasspath() {
        assertNotNull(getClass().getClassLoader().getResourceAsStream(DATATYPES_XSD_FILENAME));
    }
}
