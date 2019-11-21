package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
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
            return null;
        }
    }

    public static ValidPeriod EXAMPLE = new ValidPeriod(YearlyRepeatingPeriod.EXAMPLE);
}
