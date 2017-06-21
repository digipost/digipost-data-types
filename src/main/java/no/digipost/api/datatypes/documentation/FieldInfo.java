package no.digipost.api.datatypes.documentation;

import lombok.Value;

@Value
public class FieldInfo {
    String name;
    FieldType type;
    boolean mandatory;
    String description;
}
