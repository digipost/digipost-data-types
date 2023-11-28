package no.digipost.api.datatypes.types.pickup;

import jakarta.validation.Valid;
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

@XmlRootElement(name = "pickup-notice-status")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Updates to status for PickupNotice")
public class PickupNoticeStatus implements DataType {

    @XmlElement(name = "status", required = true)
    @Description("The status of the PickupNotice")
    @NotNull
    @Valid
    Status status;

    @XmlElement(name = "occurrence-datetime")
    @Description("ISO8601 full DateTime for time of occurrence")
    ZonedDateTime occurrenceDatetime;

    public static PickupNoticeStatus EXAMPLE = new PickupNoticeStatus(
            Status.READY_FOR_PICKUP
            , ZonedDateTime.of(2019, 1, 10, 10, 10, 0, 0, ZoneId.of("+01:00"))
    );
}
