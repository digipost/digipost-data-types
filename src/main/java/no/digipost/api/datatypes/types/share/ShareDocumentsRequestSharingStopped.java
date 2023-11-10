package no.digipost.api.datatypes.types.share;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "share-documents-request-sharing-stopped")
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Stop sharing of documents for ShareDocumentsRequest")
public class ShareDocumentsRequestSharingStopped implements DataType {

    public static final ShareDocumentsRequestSharingStopped EXAMPLE = new ShareDocumentsRequestSharingStopped();

}
