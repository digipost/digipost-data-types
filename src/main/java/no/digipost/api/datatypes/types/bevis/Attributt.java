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
public class Attributt {
    @XmlElement(name = "navn", required = true)
    @Description("")
    String30MedSpraak navn;

    @XmlElement(name = "verdi", required = true)
    @Description("")
    String100MedSpraak verdi;

    public static Attributt EXAMPLE = new Attributt(
            new String30MedSpraak("navn", new SpraakKode("NO")),
            new String100MedSpraak("verdi", new SpraakKode("NO"))
    );
}
