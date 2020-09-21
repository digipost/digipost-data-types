package no.digipost.api.datatypes.types.receipt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.types.Address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Delivery {
    @XmlElement
    String name;
    @XmlElement
    Address address;
    @XmlElement
    String terms;

    public static final Delivery EXAMPLE = new Delivery("Ola Nordmann", Address.EXAMPLE, "Delivered to the doorstep");
}
