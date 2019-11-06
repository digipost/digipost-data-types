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
        if (startYear != null && endYear != null) {

            ZonedDateTime startDate = ZonedDateTime.of(startYear, from.getMonth(), from.getDay(), from.getHour(), from.getMin(), 0, 0, ZoneId.of(from.getTimeZone()));
            ZonedDateTime endDate = ZonedDateTime.of(endYear, to.getMonth(), to.getDay(), to.getHour(), to.getMin(), 0, 0, ZoneId.of(to.getTimeZone()));

            return "R/" + startDate + "/" + endDate;
        } else if (endYear != null) {
            ZonedDateTime startDate = ZonedDateTime.of(endYear, from.getMonth(), from.getDay(), from.getHour(), from.getMin(), 0, 0, ZoneId.of(from.getTimeZone()));
            ZonedDateTime endDate = ZonedDateTime.of(endYear, to.getMonth(), to.getDay(), to.getHour(), to.getMin(), 0, 0, ZoneId.of(to.getTimeZone()));

            return "R/" + startDate.toString().substring(5) + "/" + endDate.toString();
        } else if (startYear != null) {
            ZonedDateTime startDate = ZonedDateTime.of(startYear, from.getMonth(), from.getDay(), from.getHour(), from.getMin(), 0, 0, ZoneId.of(from.getTimeZone()));
            ZonedDateTime endDate = ZonedDateTime.of(startYear, to.getMonth(), to.getDay(), to.getHour(), to.getMin(), 0, 0, ZoneId.of(to.getTimeZone()));

            return "R/" + startDate + "/" + endDate.toString().substring(5);
        }

        ZonedDateTime startDate = ZonedDateTime.of(ZonedDateTime.now().getYear(), from.getMonth(), from.getDay(), from.getHour(), from.getMin(), 0, 0, ZoneId.of(from.getTimeZone()));
        ZonedDateTime endDate = ZonedDateTime.of(ZonedDateTime.now().getYear(), to.getMonth(), to.getDay(), to.getHour(), to.getMin(), 0, 0, ZoneId.of(to.getTimeZone()));

        return "R/" + startDate.toString().substring(5) + "/" + endDate.toString().substring(5);
    }
}
