package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Heftelse {

    @XmlElement
    @NotNull
    @Size(max = 100)
    String panthaver;

    @XmlElement(name = "type-pant")
    @NotNull
    String typePant;

    @XmlElement
    @NotNull
    String beloep;
}
