package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Address {

    @XmlElement(name = "street-address")
    @Size(max = 100)
    String streetAddress;

    @XmlElement(name = "postal-code", required = true)
    @NotNull
    @Size(max = 10)
    String postalCode;

    @XmlElement
    @NotNull
    @Size(max = 100)
    String city;
}
