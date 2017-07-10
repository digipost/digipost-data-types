package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Matrikkel {

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(max = 4)
    String kommunenummer;

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(max = 4)
    String gaardsnummer;

    @XmlElement(required = true)
    @Valid
    @NotNull
    @Size(max = 4)
    String bruksnummer;

    @XmlElement()
    @Valid
    @Size(max = 4)
    String festenummer;

    @XmlElement()
    @Valid
    @Size(max = 4)
    String seksjonsnummer;

}
