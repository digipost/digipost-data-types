package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Heftelse {

    @XmlElement
    @NotNull
    @Size(max = 100)
    String panthaver;

    @XmlElement(name = "type-pant")
    @NotNull
    @Size(max = 20)
    String typePant;

    @XmlElement
    @NotNull
    String beloep;
}
