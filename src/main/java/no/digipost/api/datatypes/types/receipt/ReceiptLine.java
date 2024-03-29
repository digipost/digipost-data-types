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

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.math.BigDecimal.ZERO;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Contains details about a single item (line) on the receipt")
public class ReceiptLine {

    @XmlElement(name = "item-name")
    String itemName;

    @XmlElement(name = "item-description")
    String itemDescription;

    @XmlElement(name = "item-code")
    String itemCode;

    @XmlElement
    @Description("The unit that the item is measured in")
    String unit;

    @XmlElement
    double quantity;

    @XmlElement(name = "item-price")
    @Description("Unit item net price")
    BigDecimal itemPrice;

    @XmlElement(name = "item-vat")
    BigDecimal itemVat;

    @XmlElement(name = "total-price")
    @Description("Total line price")
    BigDecimal totalPrice;

    @XmlElement(name = "total-vat")
    @Description("Total line vat amount")
    BigDecimal totalVat;

    @XmlElement
    @Description("The amount of discount given")
    BigDecimal discount;

    @XmlElement
    String serialNumber;

    @XmlElement
    String eanCode;


    public BigDecimal getVatPercent() {
        if (itemPrice != null && itemVat != null) {
            if (itemVat.compareTo(ZERO) == 0) return BigDecimal.ZERO;
            BigDecimal priceMinusVat = itemPrice.subtract(itemVat);
            if (priceMinusVat.compareTo(ZERO) == 0) return BigDecimal.valueOf(100, 0);
            return itemVat.multiply(BigDecimal.valueOf(100)).divide(priceMinusVat, ROUND_HALF_UP).setScale(0, ROUND_HALF_UP);
        } else {
            return null;
        }
    }

    public static final ReceiptLine EXAMPLE = new ReceiptLine("Tall Cafe latte", "Tall vanilla latte with extra sugar",
            "0000012", "cup", 2.0, new BigDecimal("29.90"), new BigDecimal("5.98"),
            new BigDecimal("59.80"), new BigDecimal("11.96"), new BigDecimal("5.50"), "XY12345325GF", "1345678");
}
