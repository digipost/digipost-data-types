package no.digipost.api.datatypes.types.share;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "share-documents-request-sharing-stopped")
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@With
@Description("Stop sharing of documents for ShareDocumentsRequest")
public class ShareDocumentsRequestSharingStopped implements DataType {

    public static final ShareDocumentsRequestSharingStopped EXAMPLE = new ShareDocumentsRequestSharingStopped();

}
