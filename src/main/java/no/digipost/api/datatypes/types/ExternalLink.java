package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.WebUrl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@Wither
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("An external URL, along with an optional description and deadline for resources such as a survey.")
public class ExternalLink implements DataType {

    @XmlElement
    @XmlSchemaType(name="anyURI")
    @NotNull
    @WebUrl
    @Description("Target URL of this link. Must be http or https.")
    URI url;

    @XmlElement
    @Description("ISO8601 full DateTime. After the deadline, the button with the external url will be deactivated.")
    ZonedDateTime deadline;

    @XmlElement
    @Size(max = 70)
    @Description("A short, optional text-field, describing the external url.")
    String description;

    @XmlElement(name = "button-text")
    @Size(max = 30)
    @Description("The text which will be displayed on the button which links the user to the url-field.")
    String buttonText;

    public static ExternalLink EXAMPLE = new ExternalLink(URI.create("http://www.oslo.kommune.no/barnehage/svar-pa-tilbud-om-plass/"),
            ZonedDateTime.of(2017, 9, 30, 13, 37, 0, 0, ZoneId.systemDefault()),
            "Oslo Kommune ber deg akseptere eller avslå tilbudet om barnehageplass.", "Svar på barnehageplass");
}
