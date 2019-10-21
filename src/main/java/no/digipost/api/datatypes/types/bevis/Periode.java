package no.digipost.api.datatypes.types.bevis;

import lombok.*;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.TimeInterval;

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
public class Periode extends TidsPeriode {
    @XmlElement(name = "fra", required = true)
    @NotNull
    @Description("ISO8601 full DateTime")
    ZonedDateTime fra;

    @XmlElement(name = "til", required = true)
    @Description("ISO8601 full DateTime")
    ZonedDateTime til;

    public static TimeInterval EXAMPLE = new TimeInterval(
            ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault())
            , ZonedDateTime.of(2019, 5, 23, 16, 0, 0, 0, ZoneId.systemDefault())
    );
}
