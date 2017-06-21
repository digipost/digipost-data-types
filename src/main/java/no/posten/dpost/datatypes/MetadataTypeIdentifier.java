package no.posten.dpost.datatypes;

import no.posten.dpost.datatypes.types.Appointment;

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
public enum MetadataTypeIdentifier {
    APPOINTMENT(Appointment.class, "APPT", Appointment.EXAMPLE);

    private final Class<? extends MetadataType> metadataType;
    private final String shortName;
    private final MetadataType example;

    private static final Map<Class<? extends MetadataType>, MetadataTypeIdentifier> byType;
    private static final Map<String, MetadataTypeIdentifier> byShortName;

    static {
        byType = Stream.of(values()).collect(toMap(MetadataTypeIdentifier::getMetadataType, identity()));
        byShortName = Stream.of(values()).collect(toMap(MetadataTypeIdentifier::getShortName, identity()));
    }

    MetadataTypeIdentifier(final Class<? extends MetadataType> metadataType, final String shortName, final MetadataType example) {
        this.metadataType = metadataType;
        this.shortName = shortName;
        this.example = example;
    }

    public Class<? extends MetadataType> getMetadataType() {
        return metadataType;
    }

    public String getShortName() {
        return shortName;
    }

    public static MetadataTypeIdentifier fromRepresentationType(final Class<? extends MetadataType> representation) {
        return ofNullable(byType.get(representation))
            .orElseThrow(() -> new IllegalStateException(String.format(
                "Could not find %s for type %s. All subtypes of %s must have a unique %s.",
                MetadataTypeIdentifier.class.getSimpleName(), representation,
                MetadataType.class.getSimpleName(), MetadataTypeIdentifier.class.getSimpleName())));
    }

    public static MetadataTypeIdentifier fromShortName(final String shortName) {
        return Optional.ofNullable(byShortName.get(shortName))
            .orElseThrow(() -> new IllegalArgumentException("No value for " + MetadataTypeIdentifier.class.getSimpleName() + " found for shortName " + shortName));
    }

    public MetadataType getExample() {
        return example;
    }

    public static Set<Class<? extends MetadataType>> getAllClasses() {
        return byType.keySet();
    }
}
