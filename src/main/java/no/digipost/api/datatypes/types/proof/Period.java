package no.digipost.api.datatypes.types.proof;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.ValidPeriode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@EqualsAndHashCode(callSuper = false)
@ValidPeriode
public class Period {
    @XmlElement(name = "from")
    @Description("ISO8601 full DateTime")
    LocalDateTime from;

    @XmlElement(name = "to")
    @Description("ISO8601 full DateTime")
    LocalDateTime to;

    @Deprecated
    @JsonCreator
    public Period(@JsonProperty("from") String from, @JsonProperty("to") String to) {
        this(localDate(from), localDate(to));
    }

    private static LocalDateTime localDate(String datetime) {
        if (datetime == null) {
            return null;
        }
        final TemporalAccessor parsed = DateTimeFormatter.ISO_DATE_TIME.parse(datetime);
        if (parsed.isSupported(ChronoField.OFFSET_SECONDS)) {
            return ZonedDateTime.from(parsed).withZoneSameInstant(ZoneId.of("Europe/Oslo")).toLocalDateTime();
        } else {
            return LocalDateTime.from(parsed);
        }
    }

    public static Period EXAMPLE = new Period(
            LocalDateTime.of(2019, 5, 23, 10, 0, 0, 0)
            , LocalDateTime.of(2019, 5, 23, 16, 0, 0, 0)
    );

    public String getISO8601() {
        if (from != null && to != null) {
            return from.toString() + "/" + to.toString();
        } else if (from != null) {
            return from.toString() + "/..";
        } else if (to != null) {
            return "../" + to.toString();
        }
        return "../..";
    }
}
