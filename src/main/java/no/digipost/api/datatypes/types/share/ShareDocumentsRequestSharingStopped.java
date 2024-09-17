package no.digipost.api.datatypes.types.share;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "share-documents-request-sharing-stopped")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@With
@Description("Stop sharing of documents for ShareDocumentsRequest")
public class ShareDocumentsRequestSharingStopped implements DataType {

    @XmlElement(name="messaging-party", required = false)
    @Description("Whether the sharing was stopped by the sender or receiver.")
    MessagingParty messagingParty;

    @XmlElement(name="name", required = false)
    @Description("Name of the person or administrator who stopped the sharing.")
    String name;

    public static final ShareDocumentsRequestSharingStopped EXAMPLE = new ShareDocumentsRequestSharingStopped();

}
