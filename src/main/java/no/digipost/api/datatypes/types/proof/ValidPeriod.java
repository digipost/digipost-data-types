package no.digipost.api.datatypes.types.proof;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class ValidPeriod {

    @XmlElement(name = "period")
    @Description("")
    Period period;

    @XmlElement(name = "yearly-repeating-period")
    @Description("")
    YearlyRepeatingPeriod yearlyRepeatingPeriod;

    public ValidPeriod(YearlyRepeatingPeriod value) {
        this(null, value);
    }

    public ValidPeriod(Period value) {
        this(value, null);
    }

    private ValidPeriod(Period period, YearlyRepeatingPeriod yearlyRepeatingPeriod) {
        this.period = period;
        this.yearlyRepeatingPeriod = yearlyRepeatingPeriod;
    }

    public String getISO8601() {
        if (yearlyRepeatingPeriod != null) {
            return yearlyRepeatingPeriod.getISO8601();
        } else if (period != null) {
            return period.getISO8601();
        } else {
            return "../..";
        }
    }

    public static ValidPeriod EXAMPLE = new ValidPeriod(YearlyRepeatingPeriod.EXAMPLE);
}
