package no.posten.dpost.metadata.documentation;

import lombok.Value;

import java.util.List;

import static java.util.Collections.emptyList;

@Value
public class SimpleType implements FieldType {
    Class<?> type;

    @Override
    public List<FieldInfo> getFields() {
        return emptyList();
    }

    @Override
    public String getTypeName() {
        return type.getSimpleName();
    }

    @Override
    public boolean isComplex() {
        return false;
    }
}
