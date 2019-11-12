package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Instant;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@EqualsAndHashCode(callSuper = false)
public class YearlyRepeatingPeriod {
    @XmlElement(name = "start-year")
    @Description("")
    Integer startYear;

    @XmlElement(name = "end-year")
    @Description("")
    Integer endYear;

    @XmlElement(name = "from", required = true)
    @NotNull
    @Description("")
    CalendarDate from;
    
    @XmlElement(name = "to", required = true)
    @NotNull
    @Description("")
    CalendarDate to;

    public static YearlyRepeatingPeriod EXAMPLE = new YearlyRepeatingPeriod(
            2020,
            2022,
            new CalendarDate(1, 1, 0, 0, "+01:00"),
            new CalendarDate(12, 31, 0, 0, "+01:00")
    );
    
    public String getISO8601() {
        Instant now = Instant.now();
        ZonedDateTime startDate = buildZonedDateTime(now, from, startYear);
        ZonedDateTime endDate = buildZonedDateTime(now, to, endYear);

        if (startYear != null && endYear != null) {
            return "R/" + startDate + "/" + endDate;
        } else if (endYear != null) {
            return "R/" + startDate.toString().substring(5) + "/" + endDate.toString();
        } else if (startYear != null) {
            return "R/" + startDate + "/" + endDate.toString().substring(5);
        } else {
            return "R/" + startDate.toString().substring(5) + "/" + endDate.toString().substring(5);
        }
    }

    private static ZonedDateTime buildZonedDateTime(Instant now, CalendarDate t_date, Integer year) {
        int t_minute = 0;
        int t_hour = 0;
        int t_day = 1;
        int t_month = 1;
        ZoneId t_zone;
        t_zone = t_date.getTimeZone() != null ? ZoneId.of(t_date.getTimeZone()) : ZoneId.of("+01:00");
        t_minute = t_date.getMin() != null ? t_date.getMin() : t_minute;
        t_hour = t_date.getHour() != null ? t_date.getHour() : t_hour;
        t_day = t_date.getDay() != null ? t_date.getDay() : t_day;
        t_month = t_date.getMonth() != null ? t_date.getMonth() : t_month;
        ZonedDateTime nowInThatZone = now.atZone(t_zone);
        int t_year = year != null ? year : nowInThatZone.getYear();
        return ZonedDateTime.of(t_year, t_month, t_day, t_hour, t_minute, 0, 0, t_zone);
    }
}
