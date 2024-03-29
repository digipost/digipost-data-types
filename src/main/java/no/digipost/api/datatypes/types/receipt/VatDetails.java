package no.digipost.api.datatypes.types.receipt;

import jakarta.validation.Valid;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class VatDetails {
    @XmlElement
    @Valid
    List<VatLevel> levels;
    @XmlElement
    BigDecimal sum;

    public static final VatDetails EXAMPLE = new VatDetails(Collections.singletonList(VatLevel.EXAMPLE), new BigDecimal("64.90"));
}
