package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class MaanedsTidspunkt {
    @XmlElement(name = "maaned", required = true)
    @Size(min = 1, max = 12)
    @NotNull
    @Description("")
    Integer maaned;

    @XmlElement(name = "dag", required = true)
    @Size(min = 1, max = 31)
    @NotNull
    @Description("")
    Integer dag;

    @XmlElement(name = "time")
    @Size(min = 1, max = 23)
    @Description("")
    Integer time;

    @XmlElement(name = "min")
    @Size(min = 1, max = 59)
    @Description("")
    Integer min;

    @XmlElement(name = "tidssone", defaultValue = "+02:00")
    @Pattern(regexp = "Z|[+-][01]\\d:{0,1}[0-5]\\d|[+-][01]\\d")
    @Description("Tidssone iht ISO8601")
    String tidssone;

    public static MaanedsTidspunkt EXAMPLE = new MaanedsTidspunkt(5, 9, null, null, "+02:00");
}
