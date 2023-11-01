package no.digipost.api.datatypes.types.share;

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

@XmlRootElement(name = "share-documents-request")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A request for a user to share one or more documents")
public class ShareDocumentsRequest implements DataType {

    @XmlElement(name="max-share-duration-seconds", required = true)
    @NotNull
    @Description("This is the maximum duration in which you are allowed to access the user's documents from they are shared with you")
    Long maxShareDurationSeconds;

    @XmlElement(name="purpose", required = true)
    @NotNull
    @Description("This text should explain why you need to process the recipient's documents in a short and understandable way.")
    String purpose;

    public static final ShareDocumentsRequest EXAMPLE = new ShareDocumentsRequest(
            14 * 24 * 60 * 60L,
            "We require to see your latest pay slip in order to grant you a loan."
    );

}
