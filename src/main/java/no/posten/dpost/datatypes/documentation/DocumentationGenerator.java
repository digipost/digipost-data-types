package no.posten.dpost.datatypes.documentation;

import no.posten.dpost.datatypes.DataType;
import no.posten.dpost.datatypes.DataTypeIdentifier;
import no.posten.dpost.datatypes.marshalling.DataTypesJAXBContext;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DocumentationGenerator {

    public static void main(String[] args) throws IOException, JAXBException {
        final Path outputPath = Paths.get(args[0]);
        DocumentationGenerator.<DataType>generate(outputPath, DataTypeIdentifier.getAllClasses(), DocumentationGenerator::getMetadataExample);
    }

    public static DataType getMetadataExample(Class<? extends DataType> metadataType) {
        return DataTypeIdentifier.fromRepresentationType(metadataType).getExample();
    }

    private static <T> void generate(Path outputPath, Set<Class<? extends T>> typesToDocument, Function<Class<? extends T>, T> getExample) throws IOException, JAXBException {
        final Stream<ComplexType> types = DocumentationStructureBuilder.buildTypeStructure(typesToDocument, getExample);
        final String markdown = new MarkdownPrinter(new DataTypesJAXBContext()).print(types.collect(toList()));
        Files.write(outputPath, markdown.getBytes(StandardCharsets.UTF_8));
    }
}
