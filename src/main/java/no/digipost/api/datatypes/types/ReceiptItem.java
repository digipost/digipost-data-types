package no.digipost.api.datatypes.types;

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
@Description("Contains details about a single item (line) on the receipt")
public class ReceiptItem {

    @XmlElement
    String itemName;

    @XmlElement
    @Description("Percent VAT in the range 0.0 - 1.0")
    BigDecimal vat;

    @XmlElement
    int itemCount;

    @XmlElement
    @Description("Unit item price")
    BigDecimal price;

    public static final ReceiptItem EXAMPLE = new ReceiptItem("Tall vanilla latte with extra sugar", new BigDecimal("0.25"), 2, new BigDecimal("29.90"));
}
