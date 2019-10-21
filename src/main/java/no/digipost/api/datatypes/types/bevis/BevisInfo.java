package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class BevisInfo {
    @XmlElement(name = "navn", required = true)
    @Description("")
    String30MedSpraak navn;

    @XmlElement(name = "verdi", required = true)
    @Description("")
    String250MedSpraak verdi;

    public static BevisInfo EXAMPLE = new BevisInfo(
            new String30MedSpraak("Info#1", new SpraakKode("NO")),
            new String250MedSpraak("Verdi tekst", new SpraakKode("NO"))
    );
}
