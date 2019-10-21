package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Bruker {
    @XmlElement(name = "fornavn", required = true)
    @Description("")
    String navn;

    @XmlElement(name = "etternavn", required = true)
    @Description("")
    String verdi;

    @XmlElement(name = "foedselsnummer")
    @Pattern(regexp = "[0-9]{11}")
    @Description("")
    String foedselsnummer;

    @XmlElement(name = "adresse")
    @Description("")
    BevisAdresse adresse;

    public static Bruker EXAMPLE = new Bruker("Ola", "Nordmann", null, BevisAdresse.EXAMPLE);
}
