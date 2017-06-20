package no.posten.dpost.metadata.documentation;

import lombok.Value;

import java.util.List;

@Value
public class ComplexType implements FieldType, Comparable<ComplexType> {
    Class<?> type;
    String description;
    List<FieldInfo> fields;
    Object example;

    @Override
    public String getTypeName() {
        return type.getSimpleName();
    }

    @Override
    public boolean isComplex() {
        return true;
    }

    @Override
    public int compareTo(ComplexType o) {
        return getTypeName().compareTo(o.getTypeName());
    }
}
