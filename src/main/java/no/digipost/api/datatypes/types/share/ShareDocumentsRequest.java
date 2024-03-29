package no.digipost.api.datatypes.types.share;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.util.Set;

@XmlRootElement(name = "share-documents-request")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A request for a user to share one or more documents")
@ComplementedBy({ShareDocumentsRequestSharingStopped.class})
public class ShareDocumentsRequest implements DataType {

    @XmlElement(name="max-share-duration-seconds", required = true)
    @NotNull
    @Description("This is the maximum duration in which you are allowed to access the user's documents from they are shared with you")
    Long maxShareDurationSeconds;

    @XmlElement(name="purpose", required = true)
    @NotNull
    @Description("This text should explain why you need to process the recipient's documents in a short and understandable way.")
    String purpose;

    @XmlElement(name="allowed-origin-organisation-numbers", required = false)
    @Description("Only documents received from any of the specified organisations will be possible for the user to share.")
    Set<String> allowedOriginOrganisationNumbers;

    public static final ShareDocumentsRequest EXAMPLE = new ShareDocumentsRequest(
            14 * 24 * 60 * 60L,
            "We require to see your latest pay slip in order to grant you a loan.",
            Set.of("984661185")
    );

}
