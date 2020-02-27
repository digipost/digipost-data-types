package no.digipost.api.datatypes.types.receipt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.types.Address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Customer {
    @XmlElement
    String name;
    @XmlElement
    Address address;
    @XmlElement
    String phoneNumber;

    public static final Customer EXAMPLE = new Customer("Ola Nordmann", Address.EXAMPLE, "Delivered to the doorstep");
}
