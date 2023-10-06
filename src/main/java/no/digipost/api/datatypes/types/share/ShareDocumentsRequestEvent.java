package no.digipost.api.datatypes.types.share;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "share-documents-request-event")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("An update or event related to a ShareDocumentsRequest")
public class ShareDocumentsRequestEvent implements DataType {

    @XmlElement(name="event-type", required = true)
    @NotNull
    @Description("The type of event that has occurred")
    ShareDocumentsRequestEventType eventType;

    @XmlElement(name = "timestamp", required = true)
    @Description("When the event occurred")
    ZonedDateTime time;

    @XmlElement(name = "document-ids", required = true)
    @Description("The IDs of the documents related to this specific event")
    List<Long> documentIds;

    public static final ShareDocumentsRequestEvent EXAMPLE = createExample();

    private static ShareDocumentsRequestEvent createExample() {
        List<Long> documentIds = new ArrayList<>(1);
        documentIds.add(123L);

        return new ShareDocumentsRequestEvent(
                ShareDocumentsRequestEventType.FILES_SHARED,
                ZonedDateTime.of(2017, 9, 30, 13, 37, 0, 0, ZoneId.of("+02:00")),
                documentIds
        );
    }

}
