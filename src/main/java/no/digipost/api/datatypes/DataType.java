package no.digipost.api.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.digipost.api.datatypes.validation.ComplementedBy;

import java.util.stream.Stream;

public interface DataType {

    @JsonProperty("type")
    default String getType() {
        return getClass().getSimpleName();
    }

    @JsonIgnore
    default DataTypeIdentifier getTypeIdentifier() {
        return DataTypeIdentifier.fromRepresentationType(getClass());
    }

    default DataType withDefaultsForMissingOptionalValues() {
        return this;
    }
    
    default boolean canBeComplementedBy(DataType target) {
        return Stream.of(getClass().getAnnotationsByType(ComplementedBy.class))
                .flatMap(a -> Stream.of(a.value()))
                .anyMatch(
                        clazz -> clazz == target.getTypeIdentifier().getDataType()
                );
    }
}
