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
import java.util.Arrays;
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
    @Description("ISO8601 full DateTime. Default value 30 minutes after startTime")
    ZonedDateTime endTime;

    @XmlElement(name = "arrival-time")
    @Description("Free text but can contain a ISO8601 DateTime. Example: Please arrive 15 minutes early")
    @Size(max = 150)
    String arrivalTime;

    @XmlElement
    @Description("The name of the place. Example: Oslo City Røntgen")
    @Size(max = 150)
    String place;

    @XmlElement
    @Valid
    Address address;

    @XmlElement(name = "sub-title")
    @Size(max = 150)
    @Description("Example: MR-undersøkelse av høyre kne")
    String subTitle;

    @XmlElement
    @Valid
    @Size(max = 2)
    @Description("Additional sections of information (max 2) with a title and text")
    List<Info> info;

    @XmlElement
    @Description("Contact information, such as an email address, or a phone number")
    @Size(max = 50)
    String contactInformation;

    public static Appointment EXAMPLE = new Appointment(
                    ZonedDateTime.of(2017, 8, 4, 9, 30, 0, 0, ZoneId.systemDefault()),
                    null,
                    "Oppmøte senest 15 minutter før timen",
                    "Oslo City Røntgen",
                    new Address("Storgata 23", "0184", "Oslo"),
                    "MR-undersøkelse av høyre kne", Arrays.asList(
                    new Info("Forberedelse", "Husk å ta med gamle røntgen-bilder hvis du har dette tilgjengelig» eller informasjon om egenandel, veibeskrivelse, eller liknende"),
                    new Info("Informasjon",
                            "\n- Egenandel for undersøkelsen er kr.245,-, fritak for barn under 16 år og alle med frikort." +
                                    "\n- CD med bilder av undersøkelsen koster kr.70,- pr stk.")),
                    "kundesenter@unilabs.no");
}
