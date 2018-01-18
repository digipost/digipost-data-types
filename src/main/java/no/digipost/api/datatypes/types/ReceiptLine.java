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
public class ReceiptLine {

    @XmlElement(name = "item-name")
    @Size(max = 100)
    String itemName;

    @XmlElement(name = "itemDescription")
    String itemDescription;

    @XmlElement
    @Description("The unit that the item is measured in")
    @Size(max = 10)
    String unit;

    @XmlElement
    double quantity;

    @XmlElement(name = "item-price")
    @Description("Unit item net price")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    BigDecimal itemPrice;

    @XmlElement(name = "item-vat")
    BigDecimal itemVat;

    @XmlElement(name = "total-price")
    @Description("Total line price")
    BigDecimal totalPrice;

    @XmlElement(name = "total-vat")
    @Description("Total line vat amount")
    BigDecimal totalVat;


    public static final ReceiptLine EXAMPLE = new ReceiptLine("Tall Cafe latte", "Tall vanilla latte with extra sugar",
            "cup", 2.0, new BigDecimal("29.90"), new BigDecimal("5.98"),
            new BigDecimal("59.80"), new BigDecimal("11.96"));
}
