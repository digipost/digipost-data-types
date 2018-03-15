package no.digipost.api.datatypes.types.receipt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class VatLevel {
    @XmlElement
    BigDecimal grossAmount;
    @XmlElement
    BigDecimal netAmount;
    @XmlElement
    BigDecimal vat;
    @XmlElement
    @Description("VAT percent from 0.00 to 1.00")
    BigDecimal vatPercent;

    public static final VatLevel EXAMPLE = new VatLevel(new BigDecimal("400.00"), new BigDecimal("320.00"), new BigDecimal("80.00"), new BigDecimal("0.25"));
}
