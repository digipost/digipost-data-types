package no.digipost.api.datatypes;

import org.junit.Test;

import java.util.stream.Stream;

public class DataTypeIdentifierTest {

    @Test
    public void all_enum_values_must_be_mappable_from_data_type() {
        Stream.of(DataTypeIdentifier.values())
            .map(DataTypeIdentifier::getDataType)
            .forEach(DataTypeIdentifier::fromRepresentationType);
    }

    @Test(expected = IllegalStateException.class)
    public void unknown_data_types_should_not_be_mapable() {
        DataTypeIdentifier.fromRepresentationType(UnknownDataType.class);
    }

    static class UnknownDataType implements DataType {
    }

    @Test
    public void all_enum_values_must_be_mappable_from_shortname() {
        Stream.of(DataTypeIdentifier.values())
            .map(DataTypeIdentifier::getShortName)
            .forEach(DataTypeIdentifier::fromShortName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void unknown_shortname_should_not_be_mapable() {
        DataTypeIdentifier.fromShortName("UNKNOWN");
    }
}
