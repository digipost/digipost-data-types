package no.digipost.api.datatypes.types.share;

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

import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement(name = "share-documents-request-document-accessed")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Documents have been accessed for ShareDocumentsRequest by the receiver.")
public class ShareDocumentsRequestDocumentAccessed implements DataType {

    @XmlElement(name = "accessed-time", required = true)
    @Description("The point of time the document was accessed,")
    ZonedDateTime accessedTime;

    @XmlElement(name="accessed-by", required = true)
    @NotNull
    @Description("Name of the person or organisation who accessed the shared document.")
    String accessedBy;

    @XmlElement(required = true)
    SharedDocumentData sharedDocumentData;

    public static final ShareDocumentsRequestDocumentAccessed EXAMPLE = new ShareDocumentsRequestDocumentAccessed(
            ZonedDateTime.of(2024, 9, 16, 10, 0, 0, 0, ZoneId.of("+02:00")),
            "Whoever Accessed",
            SharedDocumentData.EXAMPLE
    );

}
