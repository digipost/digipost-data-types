package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class NameAndAddress {
    @XmlElement
    String name;
    @XmlElement
    Address address;

    public static NameAndAddress EXAMPLE = new NameAndAddress("Ola Nordmann", Address.EXAMPLE);
}
