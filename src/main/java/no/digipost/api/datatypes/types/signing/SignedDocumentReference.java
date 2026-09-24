package no.digipost.api.datatypes.types.signing;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.util.UUID;

@XmlRootElement(name = "signed-document-reference")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A reference to the signed document delivered as a result of a signing request.")
public class SignedDocumentReference implements DataType {

    @XmlElement(name = "document-uuid", required = true)
    @Description("UUID of the delivered signed document.")
    @NotNull
    UUID documentUuid;

    public static final SignedDocumentReference EXAMPLE = new SignedDocumentReference(UUID.fromString("b9d67195-6ac3-4a5e-a4d8-f5b7c2e3d1a0"));
}
