package no.digipost.api.datatypes.documentation;

import jakarta.xml.bind.JAXBException;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.DataTypeIdentifier;
import no.digipost.api.datatypes.marshalling.DataTypesJAXBContext;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DocumentationGenerator {

    public static void main(String[] args) throws IOException, JAXBException {
        final Path outputPath = Paths.get(args[0]);
        final Path examplesOutputPath = Paths.get(args[1]);
        DocumentationGenerator.<DataType>generate(outputPath, DataTypeIdentifier.getAllClasses(), DocumentationGenerator::getDataTypeExample);
        DocumentationGenerator.<DataType>generateExamples(examplesOutputPath, DataTypeIdentifier.getAllClasses(), DocumentationGenerator::getDataTypeExample);
    }

    public static DataType getDataTypeExample(Class<? extends DataType> dataType) {
        return DataTypeIdentifier.fromRepresentationType(dataType).getExample();
    }

    private static <T> void generate(Path outputPath, Set<Class<? extends T>> typesToDocument, Function<Class<? extends T>, T> getExample) throws IOException, JAXBException {
        final Stream<ComplexType> types = DocumentationStructureBuilder.buildTypeStructure(typesToDocument, getExample);
        final String markdown = new MarkdownPrinter(DataTypesJAXBContext.getSingleton(), false).print(types.collect(toList()));
        Files.write(outputPath, markdown.getBytes(StandardCharsets.UTF_8));
    }

    private static <T> void generateExamples(Path outputPath, Set<Class<? extends T>> typesToDocument, Function<Class<? extends T>, T> getExample) throws IOException, JAXBException {
        final Stream<ComplexType> types = DocumentationStructureBuilder.buildTypeStructure(typesToDocument, getExample);

        Files.write(outputPath, "".getBytes());
        Files.write(outputPath, ("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + System.lineSeparator() + "<datatypes>" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

        for (ComplexType complexType : types.collect(toList())) {
            final String xml = new MarkdownPrinter(DataTypesJAXBContext.getSingleton(), false).getXmlExample(complexType.getExample());
            Files.write(outputPath, xml.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        }

        Files.write(outputPath, "</datatypes>".getBytes(), StandardOpenOption.APPEND);
    }
}
