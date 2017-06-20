package no.posten.dpost.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface MetadataType {

    @JsonProperty("type")
    default String getType() {
        return getClass().getSimpleName();
    }

    @JsonIgnore
    default MetadataTypeIdentifier getTypeIdentifier() {
        return MetadataTypeIdentifier.fromRepresentationType(getClass());
    }
}
