package no.posten.dpost.datatypes.documentation;

import no.posten.dpost.datatypes.MetadataType;
import no.posten.dpost.datatypes.MetadataTypeIdentifier;
import no.posten.dpost.datatypes.marshalling.MetadataJAXBContext;

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
        DocumentationGenerator.<MetadataType>generate(outputPath, MetadataTypeIdentifier.getAllClasses(), DocumentationGenerator::getMetadataExample);
    }

    public static MetadataType getMetadataExample(Class<? extends MetadataType> metadataType) {
        return MetadataTypeIdentifier.fromRepresentationType(metadataType).getExample();
    }

    private static <T> void generate(Path outputPath, Set<Class<? extends T>> typesToDocument, Function<Class<? extends T>, T> getExample) throws IOException, JAXBException {
        final Stream<ComplexType> types = DocumentationStructureBuilder.buildTypeStructure(typesToDocument, getExample);
        final String markdown = new MarkdownPrinter(new MetadataJAXBContext()).print(types.collect(toList()));
        Files.write(outputPath, markdown.getBytes(StandardCharsets.UTF_8));
    }
}
