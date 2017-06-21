package no.posten.dpost.datatypes;

import org.junit.Test;

import java.util.stream.Stream;

public class MetadataTypeIdentifierTest {

    @Test
    public void all_enum_values_must_be_mappable_from_metadata_type() {
        Stream.of(MetadataTypeIdentifier.values())
            .map(MetadataTypeIdentifier::getMetadataType)
            .forEach(MetadataTypeIdentifier::fromRepresentationType);
    }

    @Test(expected = IllegalStateException.class)
    public void unknown_metadata_types_should_not_be_mapable() {
        MetadataTypeIdentifier.fromRepresentationType(UnknownMetadata.class);
    }

    static class UnknownMetadata implements MetadataType {
    }

    @Test
    public void all_enum_values_must_be_mappable_from_shortname() {
        Stream.of(MetadataTypeIdentifier.values())
            .map(MetadataTypeIdentifier::getShortName)
            .forEach(MetadataTypeIdentifier::fromShortName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unknown_shortname_should_not_be_mapable() {
        MetadataTypeIdentifier.fromShortName("UNKNOWN");
    }
}
