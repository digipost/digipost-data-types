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
    @Description("Decimal VAT")
    BigDecimal vat;

    @XmlElement
    double quantity;

    @XmlElement
    String unit;

    @XmlElement
    @Description("Unit item net price")
    BigDecimal price;

    public static final ReceiptItem EXAMPLE = new ReceiptItem("Tall vanilla latte with extra sugar", new BigDecimal("0.25"), 2.0, "stk", new BigDecimal("29.90"));
}
