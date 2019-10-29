package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class ValidPeriod {
    @XmlElements(
            {
                    @XmlElement(name = "periode", type = Period.class, required = true),
                    @XmlElement(name = "aarlig-repeterende-periode", type = YearlyRepeatingPeriod.class, required = true)
            })
    @Size(min = 1, max = 1)
    @Description("")
    TimePeriod period;

    public static ValidPeriod EXAMPLE = new ValidPeriod(YearlyRepeatingPeriod.EXAMPLE);
}
