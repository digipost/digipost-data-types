package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
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
@With
public class TimeInterval {

    @XmlElement(name = "start-time", required = true)
    @NotNull
    @Description("ISO8601 full DateTime")
    ZonedDateTime startTime;

    @XmlElement(name = "end-time", required = true)
    @Description("ISO8601 full DateTime")
    ZonedDateTime endTime;

    public static TimeInterval EXAMPLE = new TimeInterval(
            ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault())
            , ZonedDateTime.of(2019, 5, 23, 16, 0, 0, 0, ZoneId.systemDefault())
    );
}
