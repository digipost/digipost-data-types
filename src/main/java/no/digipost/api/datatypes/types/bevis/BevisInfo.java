package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class BevisInfo {
    @XmlElement(name = "navn", required = true)
    @Size(max = 30)
    @Description("")
    String navn;

    @XmlElement(name = "verdi", required = true)
    @Size(max = 2500)
    @Description("")
    String verdi;

    public static BevisInfo EXAMPLE = new BevisInfo("Info#1", "Verdi tekst");
}
