package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

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
    BigDecimal vatPercent;

    public static final VatLevel EXAMPLE = new VatLevel(new BigDecimal("400"), new BigDecimal("320"), new BigDecimal("80"), new BigDecimal("0.25"));
}