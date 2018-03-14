package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.marshalling.MoneyBigDecimalXmlAdapter;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@XmlType
@XmlJavaTypeAdapter(MoneyBigDecimalXmlAdapter.class)
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class VatDetails {
    @XmlElement
    @Valid
    List<VatLevel> levels;
    @XmlElement
    BigDecimal sum;

    public static final VatDetails EXAMPLE = new VatDetails(Collections.singletonList(VatLevel.EXAMPLE), new BigDecimal("64.90"));
}
