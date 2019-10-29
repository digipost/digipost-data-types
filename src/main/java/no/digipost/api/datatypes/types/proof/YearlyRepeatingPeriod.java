package no.digipost.api.datatypes.types.proof;

import lombok.*;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@EqualsAndHashCode(callSuper = false)
public class YearlyRepeatingPeriod implements TimePeriod {
    @XmlElement(name = "start-aar")
    @Description("")
    Integer startYear;

    @XmlElement(name = "slutt-aar")
    @Description("")
    Integer endYear;

    @XmlElement(name = "fra", required = true)
    @NotNull
    @Description("")
    MonthlyTimePoint from;

    @XmlElement(name = "til", required = true)
    @NotNull
    @Description("")
    MonthlyTimePoint to;

    public static YearlyRepeatingPeriod EXAMPLE = new YearlyRepeatingPeriod(
            2020,
            2022,
            new MonthlyTimePoint(1, 1, null, null, "Europe/Oslo"),
            new MonthlyTimePoint(12, 31, null, null, "+2:00")
    );
}
