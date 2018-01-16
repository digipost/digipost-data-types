package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
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
    @Description("The name of the item")
    @Size(max = 100)
    String itemName;

    @XmlElement
    @Description("Decimal Value Added Tax, e.g. 0.25 for 25% VAT")
    @Digits(integer = 1, fraction = 2)
    BigDecimal vat;

    @XmlElement
    double quantity;

    @XmlElement
    @Description("The unit that the item is measured in")
    @Size(max = 10)
    String unit;

    @XmlElement
    @Description("Unit item net price")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    BigDecimal price;

    public static final ReceiptItem EXAMPLE = new ReceiptItem("Tall vanilla latte with extra sugar", new BigDecimal("0.25"), 2.0, "stk", new BigDecimal("29.90"));
}
