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

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "share-documents-request-documents-shared")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Documents have been shared for ShareDocumentsRequest")
public class ShareDocumentsRequestDocumentsShared implements DataType {

    @XmlElement(name = "document-ids")
    @Description("The IDs of the documents related to this specific event")
    List<Long> documentIds;

    public static final ShareDocumentsRequestDocumentsShared EXAMPLE = createExample();

    private static ShareDocumentsRequestDocumentsShared createExample() {
        List<Long> documentIds = new ArrayList<>(1);
        documentIds.add(123L);
        return new ShareDocumentsRequestDocumentsShared(
                documentIds
        );
    }
}
