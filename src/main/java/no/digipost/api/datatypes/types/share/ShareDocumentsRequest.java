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
import java.time.Duration;

@XmlRootElement(name = "share-documents-request")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A request for a user to share one or more documents")
public class ShareDocumentsRequest implements DataType {

    @XmlElement(name="max-share-duration", required = true)
    @NotNull
    @Description("This is the maximum duration in which you are allowed to access the user's documents from they are shared with you")
    Duration maxShareDuration;

    public static final ShareDocumentsRequest EXAMPLE = new ShareDocumentsRequest(Duration.ofDays(90));

}
