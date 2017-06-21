package no.digipost.api.datatypes;

import no.digipost.api.datatypes.types.Appointment;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * HOWTO: Add new metadata type
 *
 * 1. Create new metadata type enum in this class
 * 2. Create the metadata class, annotate, implement MetadataType interface (see Appointment.class for example)
 * 3. Add class with relative package name to jaxb.index
 * 4. profit!
 */
public enum DataTypeIdentifier {
    APPOINTMENT(Appointment.class, "APPT", Appointment.EXAMPLE);

    private final Class<? extends DataType> metadataType;
    private final String shortName;
    private final DataType example;

    private static final Map<Class<? extends DataType>, DataTypeIdentifier> byType;
    private static final Map<String, DataTypeIdentifier> byShortName;

    static {
        byType = Stream.of(values()).collect(toMap(DataTypeIdentifier::getMetadataType, identity()));
        byShortName = Stream.of(values()).collect(toMap(DataTypeIdentifier::getShortName, identity()));
    }

    DataTypeIdentifier(final Class<? extends DataType> metadataType, final String shortName, final DataType example) {
        this.metadataType = metadataType;
        this.shortName = shortName;
        this.example = example;
    }

    public Class<? extends DataType> getMetadataType() {
        return metadataType;
    }

    public String getShortName() {
        return shortName;
    }

    public static DataTypeIdentifier fromRepresentationType(final Class<? extends DataType> representation) {
        return ofNullable(byType.get(representation))
            .orElseThrow(() -> new IllegalStateException(String.format(
                "Could not find %s for type %s. All subtypes of %s must have a unique %s.",
                DataTypeIdentifier.class.getSimpleName(), representation,
                DataType.class.getSimpleName(), DataTypeIdentifier.class.getSimpleName())));
    }

    public static DataTypeIdentifier fromShortName(final String shortName) {
        return Optional.ofNullable(byShortName.get(shortName))
            .orElseThrow(() -> new IllegalArgumentException("No value for " + DataTypeIdentifier.class.getSimpleName() + " found for shortName " + shortName));
    }

    public DataType getExample() {
        return example;
    }

    public static Set<Class<? extends DataType>> getAllClasses() {
        return byType.keySet();
    }
}
