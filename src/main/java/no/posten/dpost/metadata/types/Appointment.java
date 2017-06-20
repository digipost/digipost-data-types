package no.posten.dpost.metadata.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.posten.dpost.metadata.MetadataType;
import no.posten.dpost.metadata.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("Appointment represents a meeting set for a specific place and time")
public class Appointment implements MetadataType {

    @XmlElement(required = true)
    @NotNull
    @Size(max = 140)
    String title;

    @XmlElement(required = true)
    @NotNull
    @Description("Date and time for the appointment")
    ZonedDateTime time;

    @XmlElement(required = true)
    @NotNull
    @Valid
    Address place;

    @XmlElement
    @Description("Additional information about the appointment")
    @Size(max = 200)
    String description;

    @XmlElement
    @Description("Additional information about the appointment time. Example: Please arrive 10 minutes ahead of scheduled time")
    @Size(max = 200)
    String timeInformation;

    public static Appointment EXAMPLE = new Appointment(
        "Time hos Dr. Legesen",
        ZonedDateTime.of(2017, 6, 27, 10, 0, 0, 0, ZoneId.of("GMT+02:00")),
        new Address("Storgata 23", "0011", "Oslo"),
        "Undersøke smerter i ryggen",
        "Oppmøte senest 10 minutter før timen");
}
