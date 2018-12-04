package no.digipost.api.datatypes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    
}
