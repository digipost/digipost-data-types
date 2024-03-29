package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Address {

    @XmlElement(name = "street-address")
    @Size(max = 100)
    @Description("E.g. Storgata 11")
    String streetAddress;
    
    @XmlElement(name = "street-address-2")
    @Size(max = 100)
    @Description("E.g. Romerike Næringspark")
    String streetAddress2;

    @XmlElement(name = "postal-code")
    @Size(max = 10)
    String postalCode;

    @XmlElement
    @Size(max = 100)
    String city;

    @XmlElement
    String country;

    public static final Address EXAMPLE = new Address("Storgata 23", null, "0011", "Oslo", "Norge");
}
