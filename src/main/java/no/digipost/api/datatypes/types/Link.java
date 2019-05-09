package no.digipost.api.datatypes.types;

import lombok.*;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.WebUrl;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("A link is a represention of an <a> element in html with href-url and a text. <a href='url'>description</a>")
public class Link {
    
    @XmlElement(required = true)
    @XmlSchemaType(name="anyURI")
    @NotNull
    @WebUrl
    @Description("Target URL of this link. Must be http or https.")
    URI url;
    
    @XmlElement(required = true)
    @Size(max = 70)
    @Description("The text-part of av an <a> html element.")
    String description;

    public static Link EXAMPLE = new Link(URI.create("https://valg.no"),
            "Les mer om valget på valg.no");
}
