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
public class String30MedSpraak {
    @XmlElement(name = "", required = true)
    @Size(min = 1, max = 30)
    @Description("")
    String text;

    @XmlElement(name = "lang", required = true)
    @Description("")
    SpraakKode spraakKode;

    public static String30MedSpraak EXAMPLE = new String30MedSpraak("String under 30 characters", new SpraakKode("NO"));
}
