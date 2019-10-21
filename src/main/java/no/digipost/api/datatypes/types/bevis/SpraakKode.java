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
public class SpraakKode {
    @XmlElement(name = "lang", required = true)
    @Size(min = 2, max = 2)
    @Description("Språkkode ihht ISO-639-1 (2 bokstaver)")
    String spraakKode;

    public static SpraakKode EXAMPLE = new SpraakKode("NO");
}
