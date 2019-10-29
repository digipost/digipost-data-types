package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.validation.ValidPeriode;

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
@ValidPeriode
public class Period implements TimePeriod {
    @XmlElement(name = "from")
    @Description("ISO8601 full DateTime")
    ZonedDateTime from;

    @XmlElement(name = "to")
    @Description("ISO8601 full DateTime")
    ZonedDateTime to;

    public static Period EXAMPLE = new Period(
            ZonedDateTime.of(2019, 5, 23, 10, 0, 0, 0, ZoneId.systemDefault())
            , ZonedDateTime.of(2019, 5, 23, 16, 0, 0, 0, ZoneId.systemDefault())
    );
}
