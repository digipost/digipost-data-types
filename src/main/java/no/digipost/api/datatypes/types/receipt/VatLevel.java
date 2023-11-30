package no.digipost.api.datatypes.types.receipt;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

import java.math.BigDecimal;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class VatLevel {
    @XmlElement
    BigDecimal grossAmount;
    @XmlElement
    BigDecimal netAmount;
    @XmlElement
    BigDecimal vat;
    @XmlElement
    @Description("VAT percent from 0 to 100")
    BigDecimal vatPercent;

    public static final VatLevel EXAMPLE = new VatLevel(new BigDecimal("400.00"), new BigDecimal("320.00"), new BigDecimal("80.00"), new BigDecimal("25.00"));
}
