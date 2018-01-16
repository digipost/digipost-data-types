package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Contains details about a payment carried out as part of this purchase")
public class Payment {

    @XmlElement(name = "bank-account")
    @Description("The norwegian bank account number associated with the purchase, if applicable")
    @Digits(integer = 11, fraction = 0)
    String bankAccount;

    @XmlElement(name = "card-number")
    @Description("The obscured card number associated with the purchase")
    @Pattern(regexp = "[0-9*]{0,16}")
    String cardNumber;

    @XmlElement
    @Description("Free text field for other types of payments, e.g. vouchers, cash")
    @Size(max = 50)
    String other;

    @XmlElement
    @Description("Amount payed in this payment")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    BigDecimal amount;

    @XmlElement(name = "currency")
    @Size(max = 3)
    @Description("Currency of the payment, ISO4217. Example: NOK")
    String currencyCode;

    public static final Payment EXAMPLE = new Payment(null, "************1234", null, BigDecimal.valueOf(142), "NOK");
}
