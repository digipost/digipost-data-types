package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "verifiable-credential-notice")
@XmlType(propOrder = {"title", "description"})
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Represents a legal document (Certificate, Licence, Permit, etc.) issued to a single person.")
public class VerifiableCredentialNotice implements DataType {

    @XmlElement
    @Description("The title of the credential.")
    String title;

    @XmlElement
    @Description("A detailed explanation of the credential.")
    String description;

    public static VerifiableCredentialNotice EXAMPLE = new VerifiableCredentialNotice(
            "Drivers Licence",
            "This document confirms that the holder has a license to drive vehicles under the specified categories."
    );
}
