package no.digipost.api.datatypes.types.proof;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
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
    @Description("Deprecated, do not use. Will be ignored.")
    String timeZone;

    @Deprecated
    public CalendarDate(Integer month, Integer day, Integer hour, Integer min, String timeZone) {
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.timeZone = timeZone;
    }

    public CalendarDate(Integer month, Integer day, Integer hour, Integer min) {
        this(month, day, hour, min, null);
    }


    public static CalendarDate EXAMPLE = new CalendarDate(5, 9, 0, 0);
}
