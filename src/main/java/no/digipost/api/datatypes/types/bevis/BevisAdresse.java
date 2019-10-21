package no.digipost.api.datatypes.types.bevis;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class BevisAdresse {

    @XmlElement(name = "gate", required = true)
    @NotNull
    @Size(max = 100)
    @Description("E.g. Storgata 11")
    String gate;

    @XmlElement(name = "postnummer", required = true)
    @NotNull
    @Size(max = 10)
    String postnummer;

    @XmlElement(name = "sted", required = true)
    @Size(max = 100)
    String sted;

    @XmlElement(name = "land")
    @Size(max = 100)
    String land;

    public static final BevisAdresse EXAMPLE = new BevisAdresse("Storgata 23", "0011", "Oslo", "Norge");
}
