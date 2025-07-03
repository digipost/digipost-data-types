package no.digipost.api.datatypes.types.verifiableCredential;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.marshalling.ZonedDateTimeXmlAdapter;

import java.time.ZonedDateTime;

@XmlRootElement(name = "verifiable-credential-notice")
@XmlType(propOrder = {"credentialId", "validFrom", "validUntil", "title", "description"})
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Represents a legal document (Certificate, Licence, Permit, etc.) issued to a single person.")
public class VerifiableCredentialNotice implements DataType {

    @XmlElement(name = "credential-id", required = true)
    @Description("A unique identifier for the credential.")
    String credentialId;

    @XmlElement(name = "valid-from")
    @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
    @Description("The starting point of validity for the credential.")
    ZonedDateTime validFrom;

    @XmlElement(name = "valid-until")
    @XmlJavaTypeAdapter(ZonedDateTimeXmlAdapter.class)
    @Description("The ending point of validity for the credential.")
    ZonedDateTime validUntil;

    @XmlElement
    @Description("The title of the credential.")
    String title;

    @XmlElement
    @Description("A detailed explanation of the credential.")
    String description;

    public static VerifiableCredentialNotice EXAMPLE = new VerifiableCredentialNotice(
            "DL-1234567890",
            ZonedDateTime.parse("2025-01-01T10:00:00+02:00"),
            ZonedDateTime.parse("2030-01-01T10:00:00+02:00"),
            "Drivers Licence",
            "This document confirms that the holder has a license to drive vehicles under the specified categories."
    );
}
