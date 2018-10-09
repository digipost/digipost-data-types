package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class PickupPlace {

    @XmlElement(name = "name", required = true)
    @Description("The pickup place name")
    String name;

    @XmlElement(name = "id", required = true)
    @Description("The pickup place id")
    String id;

    @XmlElement(name = "instruction", required = true)
    @Description("instructions for fetching the parcel")
    String instruction;

    @XmlElement(name = "shelf-location")
    @Description("shelf location at pickup point")
    String shelfLocation;

    @XmlElement
    Address address;

    public static final PickupPlace EXAMPLE = new PickupPlace("0132", "Coop Mega", "Må hentes innen 010180", "H32", Address.EXAMPLE);


}
