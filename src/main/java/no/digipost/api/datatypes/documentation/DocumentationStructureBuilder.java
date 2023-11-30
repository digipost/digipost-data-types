package no.digipost.api.datatypes.documentation;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import no.digipost.api.datatypes.ComplementedBy;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.lang.reflect.Modifier.isStatic;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DocumentationStructureBuilder {

    public static <T> Stream<ComplexType> buildTypeStructure(Set<Class<? extends T>> classes, Function<Class<? extends T>, T> getExample) {
        return classes.stream().map(getTypeInfoWithExample(getExample)).sorted();
    }

    private static <T> Function<? super Class<? extends T>, ComplexType> getTypeInfoWithExample(Function<Class<? extends T>, T> getExample) {
        return type -> new ComplexType(type, getDescription(type), getFieldInfos(type), getExample.apply(type), getComplementables(type));
    }

    private static List<ComplexType> getComplementables(Class<?> dataType){
        return Optional.ofNullable(dataType.getAnnotation(ComplementedBy.class))
                .map(ComplementedBy::value)
                .map(Stream::of)
                .orElseGet(Stream::empty)
                .map(c -> new ComplexType(c, null, null, null, Collections.emptyList()))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }
    
    private static List<FieldInfo> getFieldInfos(Class<?> dataType) {
        return Stream.of(dataType.getDeclaredFields()).filter(f -> !isStatic(f.getModifiers())).map(getFieldInfo()).collect(toList());
    }

    private static Function<Field, FieldInfo> getFieldInfo() {
        return field -> new FieldInfo(field.getName(), resolveTypeOfField(field.getType()), isMandatory(field), getDescription(field));
    }

    private static String getDescription(AnnotatedElement element) {
        return Stream.of(element.getAnnotationsByType(Description.class)).map(Description::value).collect(joining(lineSeparator()));
    }

    private static boolean isMandatory(Field field) {
        final boolean requiredXmlElement = Stream.of(field.getAnnotationsByType(XmlElement.class)).anyMatch(XmlElement::required);
        final boolean notNull = field.getAnnotationsByType(NotNull.class).length > 0;
        return requiredXmlElement || notNull;
    }
  
    private static FieldType resolveTypeOfField(Class<?> fieldType) {
        if (fieldType.getPackage().isAnnotationPresent(DataTypePackage.class)) {
            return new ComplexType(fieldType, getDescription(fieldType), getFieldInfos(fieldType), null, Collections.emptyList());
        } else {
            return new SimpleType(fieldType);
        }
    }
}
