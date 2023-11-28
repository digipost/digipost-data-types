package no.digipost.api.datatypes.types.proof;

import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

import java.time.LocalDateTime;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
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
    @Description("The date each year the proof becomes valid")
    CalendarDate from;
    
    @XmlElement(name = "to", required = true)
    @NotNull
    @Description("The date each year the proof stops being valid")
    CalendarDate to;

    public static YearlyRepeatingPeriod EXAMPLE = new YearlyRepeatingPeriod(
            2020,
            2022,
            new CalendarDate(1, 1, null, null),
            new CalendarDate(12, 31, 0, 0)
    );
    
    public String getISO8601() {
        String startDate = writeLocalDate(from, startYear);
        String endDate = writeLocalDate(to, endYear);

        if (startYear != null && endYear != null) {
            return "R/" + startDate + "/" + endDate;
        } else if (endYear != null) {
            return "R/" + startDate.substring(5) + "/" + endDate;
        } else if (startYear != null) {
            return "R/" + startDate + "/" + endDate.substring(5);
        } else {
            return "R/" + startDate.substring(5) + "/" + endDate.substring(5);
        }
    }

    private static String writeLocalDate(CalendarDate t_date, Integer year) {
        int t_minute = 0;
        int t_hour = 0;
        int t_day = 1;
        int t_month = 1;
        t_minute = t_date.getMin() != null ? t_date.getMin() : t_minute;
        t_hour = t_date.getHour() != null ? t_date.getHour() : t_hour;
        t_day = t_date.getDay() != null ? t_date.getDay() : t_day;
        t_month = t_date.getMonth() != null ? t_date.getMonth() : t_month;
        int t_year = year != null ? year : 2019; // note: the default value will be discarded, but we need it to create a LocalDateTime
        return LocalDateTime.of(t_year, t_month, t_day, t_hour, t_minute, 0, 0).toString();
    }
}
