package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;
import no.digipost.api.datatypes.types.Info;
import no.digipost.api.datatypes.types.receipt.Barcode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Details about a signed document")
public class PickupNotice implements DataType {
    
    @XmlElement(name = "parcel-id", required = true)
    @Description("The id of the parcel in posten")
    String parcelId;
    
    @XmlElement(name = "parcel-uuid", required = true)
    @Description("The uuid of the parcel")
    String parcelUUID;
    
    @XmlElement(name = "bar-code", required = true)
    @Description("Bar code")
    Barcode barcode;
    
    @XmlElement(name = "recipient", required = true)
    @Description("The recipient of the parcel")
    Recipient recipient;
    
    @XmlElement(name = "sender", required = true)
    @Description("The sender of the parcel")
    Sender sender;
    
    @XmlElement(name = "pickup-place", required = true)
    @Description("where the parcel can be fetched")
    PickupPlace pickupPlace;
    
    public static PickupNotice EXAMPLE = new PickupNotice(
            "KB432788293NO"
            , "70300492517312675"
            , Barcode.EXAMPLE.withBarcodeType("EAN-128")
            , Recipient.EXAMPLE
            , Sender.EXAMPLE
            , PickupPlace.EXAMPLE
    );
}


