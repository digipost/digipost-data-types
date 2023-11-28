package no.digipost.api.datatypes.types.receipt;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.types.Address;

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
