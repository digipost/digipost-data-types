package no.posten.dpost.datatypes.documentation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import no.posten.dpost.datatypes.marshalling.MetadataJAXBContext;
import no.posten.dpost.datatypes.marshalling.MetadataJsonMapper;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class MarkdownPrinter {

    private static String LF = lineSeparator();
    private static String LLF = LF + LF;


    private final MetadataJAXBContext jaxb;

    public MarkdownPrinter(MetadataJAXBContext jaxb) {
        this.jaxb = jaxb;
    }


    public String print(List<ComplexType> typeInfos) {
        return     printHeader(typeInfos) + LLF +
                printTypes(typeInfos) + LF;
    }

    private String printTypes(List<ComplexType> typeInfos) {
        return typeInfos.stream().map(this::printTypeOverview).collect(joining(LLF));
    }

    private String printHeader(List<ComplexType> metadataTypeInfos) {
        return     heading(2, "Metadata types") + LLF +
                "|Type|Description|" + LF +
                "|----|-----------|" + LF +
                metadataTypeInfos.stream().map(t ->
                "|" + printLink(t) + "|" + t.getDescription() + "|"
                ).collect(joining(LF));
    }

    private String printTypeOverview(ComplexType typeInfo) {
        return     heading(2, typeInfo.getTypeName()) + LLF +
                typeInfo.getDescription() + LLF +
                heading(3, "Fields") + LLF +
                printFields(typeInfo.getFields()) + LLF +
                printJsonExample(typeInfo.getExample()) + LLF +
                printXmlExample(typeInfo.getExample());
    }

    private String printXmlExample(Object example) {
        try {
            final StringWriter writer = new StringWriter();
            final Marshaller marshaller = jaxb.getContext().createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(example, writer);
            return    heading(3, "XML") + LLF +
                    code("xml", writer.toString().trim());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private String code(String type, String s) {
        return "```" + type + LF + s + LF + "```";
    }

    private String printJsonExample(Object example) {
        try {
            return     heading(3, "JSON") + LLF +
                    code("json",
                    MetadataJsonMapper.getMapper()
                        .configure(SerializationFeature.INDENT_OUTPUT, true)
                        .writeValueAsString(example).trim());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String printTypeInfo(ComplexType type) {
        return    heading(3, type.getTypeName()) + LLF +
                printFields(type.getFields());
    }

    private String printFields(List<FieldInfo> fields) {
        final String subTypes = fields.stream().map(FieldInfo::getType).filter(FieldType::isComplex).map(t -> (ComplexType) t).map(this::printTypeInfo).collect(joining());
        return    "|Name|Type|Required|Description|" + LF +
                "|----|----|--------|-----------|" + LF +
                fields.stream().map(this::printField).collect(joining(LF)) +
                (subTypes.isEmpty() ? subTypes : LLF + subTypes);
    }

    private String printField(FieldInfo f) {
        final String type = f.getType().isComplex() ? printLink(f.getType()) : f.getType().getTypeName();
        return "|" + f.getName() + "|" + type + "|" + f.isMandatory() + "|" + f.getDescription() + "|";
    }

    private String printLink(FieldType f) {
        return "[" + f.getTypeName() + "](#" + f.getTypeName().toLowerCase().replaceAll(" ", "-") + ")";
    }

    private String heading(int level, String heading) {
        return Stream.generate(() -> "#").limit(level).collect(joining()) + " " + heading;
    }
}
