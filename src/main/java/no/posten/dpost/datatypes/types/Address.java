package no.posten.dpost.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Address {
    @Size(max = 200)
    String streetAddress;
    @Size(max = 10)
    String postalCode;
    @NotNull
    @Size(max = 200)
    String city;
}
