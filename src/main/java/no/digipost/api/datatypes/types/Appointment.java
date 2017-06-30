package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Appointment represents a meeting set for a specific place and time")
public class Appointment implements DataType {


    @XmlElement(name = "start-time", required = true)
    @NotNull
    @Description("ISO8601 full DateTime")
    ZonedDateTime startTime;

    @XmlElement(name = "end-time")
    @Description("ISO8601 full DateTime. Default value 1 hour after startTime")
    ZonedDateTime endTime;

    @XmlElement(name = "arrival-time")
    @Description("Free text but can contain a ISO8601 DateTime. Example: Please arrive 15 minutes early")
    @Size(max = 150)
    String arrivalTime;

    @XmlElement
    @Description("The name of the place. Example: Oslo City Røntgen")
    @Size(max = 100)
    String place;

    @XmlElement
    @Valid
    Address address;

    @XmlElement(name = "sub-title")
    @Size(max = 140)
    @Description("Example: MR-undersøkelse av høyre kne")
    String subTitle;

    @XmlElement
    @Valid
    @Size(max = 2)
    @Description("Additional sections of information (max 2) with a title and text")
    List<Info> info;

    public static Appointment EXAMPLE = new Appointment(
        ZonedDateTime.of(2017, 6, 27, 10, 0, 0, 0, ZoneId.of("GMT+02:00")),
            ZonedDateTime.of(2017, 6, 27, 11, 0, 0, 0, ZoneId.of("GMT+02:00")),
        "Oppmøte senest 15 minutter før timen",
        "Oslo City Røntgen",
         new Address("Storgata 23", "0011", "Oslo"),
        "Undersøke smerter i ryggen", Collections.singletonList(
                new Info("Informasjon om Oslo City Røntgen", "Oslo City Røntgen er et spesialistsenter for avansert bildediagnostikk.")));
}
