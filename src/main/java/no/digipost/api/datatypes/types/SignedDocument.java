package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Details about a signed document")
public class SignedDocument implements DataType {

    @XmlElement(name = "document-issuer", required = true)
    @Description("The original issuer of the document to be signed.")
    String documentIssuer;

    @XmlElement(name = "document-subject", required = true)
    @Description("The original subject of the document to be signed.")
    String documentSubject;

    @XmlElement(name = "signing-time", required = true)
    @Description("When the recipient signed the document. ISO8601 full DateTime.")
    @NotNull
    ZonedDateTime signingTime;

    public static SignedDocument EXAMPLE = new SignedDocument(
            "Bedrift AS",
            "Ansettelseskontrakt",
            ZonedDateTime.of(2018, 7, 11, 10, 0, 0, 0, ZoneId.of("+02:00"))
    );
}


