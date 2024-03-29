package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.WebUrl;

import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@With
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("An external URL, along with an optional description and deadline for resources such as a survey.")
public class ExternalLink implements DataType {

    /**
     * Required args constructor
     */
    public ExternalLink(final URI url) {
        this(url, null, null, null);
    }

    @XmlElement(required = true)
    @XmlSchemaType(name="anyURI")
    @NotNull
    @WebUrl
    @Description("Target URL of this link. Must be http or https.")
    URI url;

    @XmlElement
    @XmlSchemaType(name="dateTime")
    @Description("Optional deadline for the user to respond. ISO8601 full DateTime.")
    ZonedDateTime deadline;

    @XmlElement
    @Size(max = 300)
    @Description("A short, optional text-field, describing the external link.")
    String description;

    @XmlElement(name = "button-text")
    @Size(max = 30)
    @Description("Optional text which will be displayed on the button.")
    String buttonText;

    public static ExternalLink EXAMPLE = new ExternalLink(URI.create("https://www.oslo.kommune.no/barnehage/svar-pa-tilbud-om-plass/"),
            ZonedDateTime.of(2017, 9, 30, 13, 37, 0, 0, ZoneId.of("+02:00")),
            "Oslo Kommune ber deg akseptere eller avslå tilbudet om barnehageplass.", "Svar på barnehageplass");

    public static ExternalLink EXAMPLE_NO_DEADLINE = new ExternalLink(URI.create("https://www.example.com"),
            null,
            "Gå til avsenders side for å gjøre en handling", "Ta meg til handling!");
}
