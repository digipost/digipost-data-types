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
public class MonthlyTimePoint {
    @XmlElement(name = "month", required = true)
    @Size(min = 1, max = 12)
    @NotNull
    @Description("")
    Integer month;

    @XmlElement(name = "day", required = true)
    @Size(min = 1, max = 31)
    @NotNull
    @Description("")
    Integer day;

    @XmlElement(name = "hour")
    @Size(min = 1, max = 23)
    @Description("")
    Integer hour;

    @XmlElement(name = "min")
    @Size(min = 1, max = 59)
    @Description("")
    Integer min;

    @XmlElement(name = "time-zone", defaultValue = "+02:00")
    @Pattern(regexp = "Z|[+-][01]\\d:{0,1}[0-5]\\d|[+-][01]\\d")
    @Description("Tidssone iht ISO8601")
    String timeZone;

    public static MonthlyTimePoint EXAMPLE = new MonthlyTimePoint(5, 9, null, null, "+02:00");
}
