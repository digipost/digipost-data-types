package no.posten.dpost.metadata.documentation;


import java.util.List;

public interface FieldType {
    Class<?> getType();
    List<FieldInfo> getFields();
    String getTypeName();
    boolean isComplex();
}
