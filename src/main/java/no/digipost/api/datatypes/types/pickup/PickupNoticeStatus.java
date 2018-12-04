package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pickup-notice-status")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Updates to status for PickupNotice")
public class PickupNoticeStatus implements DataType {

    @XmlElement(name = "status", required = true)
    @Description("The status of the PickupNotice")
    @NotNull
    @Valid
    Status status;

    public static PickupNoticeStatus EXAMPLE = new PickupNoticeStatus(
            Status.READY_FOR_PICKUP
    );
}
