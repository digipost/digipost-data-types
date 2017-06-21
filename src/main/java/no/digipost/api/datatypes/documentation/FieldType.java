package no.digipost.api.datatypes.documentation;


import java.util.List;

public interface FieldType {
    Class<?> getType();
    List<FieldInfo> getFields();
    String getTypeName();
    boolean isComplex();
}
