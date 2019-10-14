package no.digipost.api.datatypes;

import org.junit.jupiter.api.Test;

import static co.unruly.matchers.Java8Matchers.where;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.arbitrary;


class DataTypeIdentifierTest {

    @Test
    void all_enum_values_must_be_mappable_from_data_type() {
        qt().forAll(arbitrary().enumValues(DataTypeIdentifier.class))
            .checkAssert(dataTypeIdentifier ->
                assertThat(dataTypeIdentifier.getDataType(), where(DataTypeIdentifier::fromRepresentationType, is(dataTypeIdentifier))));
    }

    @Test
    void unknown_data_types_should_not_be_mapable() {
        assertThrows(IllegalStateException.class, () -> DataTypeIdentifier.fromRepresentationType(UnknownDataType.class));
    }

    static class UnknownDataType implements DataType {
    }

    @Test
    void all_enum_values_must_be_mappable_from_shortname() {
        qt().forAll(arbitrary().enumValues(DataTypeIdentifier.class))
            .checkAssert(dataTypeIdentifier ->
                assertThat(dataTypeIdentifier.getShortName(), where(DataTypeIdentifier::fromShortName, is(dataTypeIdentifier))));
    }

    @Test
    void unknown_shortname_should_not_be_mapable() {
        assertThrows(IllegalArgumentException.class, () -> DataTypeIdentifier.fromShortName("UNKNOWN"));
    }
}
