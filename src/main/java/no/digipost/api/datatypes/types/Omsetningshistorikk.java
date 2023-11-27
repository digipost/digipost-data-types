package no.digipost.api.datatypes.types;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.ZonedDateTime;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A previous transaction or sale")
public class Omsetningshistorikk {

    @XmlElement(name = "dato", required = true)
    @NotNull
    @Description("ISO8601 full DateTime")
    ZonedDateTime dato;

    @XmlElement
    @Size(max = 50)
    String beskrivelse;

    @XmlElement
    String selger;

    @XmlElement
    String kjoeper;

    @XmlElement
    Long beloep;
}
