package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.receipt.Barcode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement(name = "pickup-notice")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Details about a pickup notice")
public class PickupNotice implements DataType {
    
    @XmlElement(name = "parcel-id", required = true)
    @Description("The id of the parcel in posten")
    @NotNull
    @Valid
    String parcelId;
    
    @XmlElement(name = "parcel-uuid")
    @Description("The uuid of the parcel")
    String parcelUUID;
    
    @XmlElement(name = "barcode", required = true)
    @Description("Barcode")
    Barcode barcode;
    
    @XmlElement(name = "product-name")
    @Description("Mail Service product name")
    String productName;
    
    @XmlElement(name = "arrival-date-time", required = true)
    @Description("ISO8601 full DateTime for arrival at pickup place")
    @Valid
    ZonedDateTime arrivalDateTime;
    
    @XmlElement(name = "return-date-time", required = true)
    @Description("ISO8601 full DateTime for return back to sender")
    @Valid
    ZonedDateTime returnDateTime;
    
    @XmlElement(name = "recipient", required = true)
    @Description("The recipient of the parcel")
    @NotNull
    @Valid
    Recipient recipient;
    
    @XmlElement(name = "sender")
    @Description("The sender of the parcel")
    @Valid
    Sender sender;
    
    @XmlElement(name = "pickup-place", required = true)
    @Description("where the parcel can be fetched")
    @NotNull
    @Valid
    PickupPlace pickupPlace;

    @XmlElement(name = "package")
    @Description("package information")
    Package thePackage;
    
    @XmlElement(name = "cost")
    @Description("Information about value, mva, customs processing and more")
    Cost cost;
    
    public static PickupNotice EXAMPLE = new PickupNotice(
            "KB432788293NO"
            , "70300492517312675"
            , Barcode.EXAMPLE.withBarcodeType("CODE_128")
            , "Klimanøytral Servicepakke"
            , ZonedDateTime.of(2018, 9, 10, 10, 0, 0, 0, ZoneId.systemDefault())
            , ZonedDateTime.of(2018, 9, 24, 10, 0, 0, 0, ZoneId.systemDefault())
            , Recipient.EXAMPLE
            , Sender.EXAMPLE
            , PickupPlace.EXAMPLE
            , Package.EXAMPLE
            , Cost.EXAMPLE
    );
}


