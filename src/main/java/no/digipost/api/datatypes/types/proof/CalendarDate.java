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
public class CalendarDate {
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

    @XmlElement(name = "hour", defaultValue = "0")
    @Size(min = 0, max = 23)
    @Description("")
    Integer hour;

    @XmlElement(name = "min", defaultValue = "0")
    @Size(min = 0, max = 59)
    @Description("")
    Integer min;

    @XmlElement(name = "time-zone", defaultValue = "+01:00")
    @Pattern(regexp = "Z|[+-][01]\\d:{0,1}[0-5]\\d|[+-][01]\\d")
    @Description("Timezone ISO-8601")
    String timeZone;

    public static CalendarDate EXAMPLE = new CalendarDate(5, 9, 0, 0, "+01:00");
}
