package no.digipost.api.datatypes.types.pickup;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
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
