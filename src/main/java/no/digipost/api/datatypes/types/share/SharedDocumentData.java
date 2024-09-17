package no.digipost.api.datatypes.types.share;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

import java.math.BigInteger;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Contains details about a shared document")
public class SharedDocumentData {

    @XmlElement(name = "delivery-time", required = true)
    ZonedDateTime deliveryTime;

    @XmlElement(required = true)
    String subject;

    @XmlElement(name = "file-type", required = true)
    String fileType;

    @XmlElement(name = "file-size-bytes", required = true)
    BigInteger fileSizeBytes;

    @XmlElement(required = true)
    SharedDocumentOrigin origin;

    public static final SharedDocumentData EXAMPLE = new SharedDocumentData(
            ZonedDateTime.of(2024, 9, 16, 10, 0, 0, 0, ZoneId.of("+02:00")),
            "Subject",
            "PDF",
            BigInteger.ONE,
            new SharedDocumentOrigin().withOrganisation(SharedDocumentOriginOrganisation.EXAMPLE)
    );

}
