package no.posten.dpost.metadata.marshalling;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class XsdTest {
    @Test
    public void generatedXsdShouldBeOnClasspath() {
        assertNotNull(getClass().getClassLoader().getResourceAsStream("metadata.xsd"));
    }
}
