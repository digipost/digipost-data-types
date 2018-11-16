package no.digipost.api.datatypes.types.pickup;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

import javax.validation.constraints.NotNull;
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
    @NotNull
    String name;

    @XmlElement(name = "code", required = true)
    @Description("The pickup code")
    String code;

    @XmlElement(name = "instruction", required = true)
    @Description("instructions for fetching the parcel")
    String instruction;

    @XmlElement(name = "shelf-location")
    @Description("shelf location at pickup point")
    String shelfLocation;

    @XmlElement
    @NotNull
    Address address;

    public static final PickupPlace EXAMPLE = new PickupPlace("Coop Mega", "RC89", "Må hentes innen 010180", "H32", Address.EXAMPLE);
    
}
