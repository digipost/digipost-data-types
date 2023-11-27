package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.WebUrl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import java.net.URI;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
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
