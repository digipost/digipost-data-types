package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import lombok.*;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.WebUrl;

import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Description("A link to a signature request, with a description and a deadline.")
public class SignatureRequest implements DataType {

    @XmlElement(required = true)
    @XmlSchemaType(name="anyURI")
    @WebUrl
    @Description("Target URL of this link. Must be http or https.")
    URI url;

    @XmlElement(required = true)
    @XmlSchemaType(name="dateTime")
    @Description("Deadline for the request. ISO8601 full DateTime.")
    ZonedDateTime deadline;

    @XmlElement(required = true)
    @Size(max = 300)
    @Description("A short text-field describing the request.")
    String description;

    @XmlElement(name = "button-text", required = true)
    @Size(max = 30)
    @Description("Text which will be displayed on the button.")
    String buttonText;

    public static SignatureRequest EXAMPLE = new SignatureRequest(URI.create("https://www.signering.posten.no/"),
            ZonedDateTime.of(2025, 9, 30, 13, 37, 0, 0, ZoneId.of("+02:00")),
            "Du har mottatt en signeringsforespørsel fra Bedrift AS", "Les og signer");
}
