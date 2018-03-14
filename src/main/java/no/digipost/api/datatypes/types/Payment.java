package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.marshalling.MoneyBigDecimalXmlAdapter;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@XmlType
@XmlJavaTypeAdapter(MoneyBigDecimalXmlAdapter.class)
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Contains details about a payment carried out as part of this purchase")
public class Payment {

    @XmlElement
    @Description("Payment type. Examples: Credit Card, BankAxept, Cash")
    String type;

    @XmlElement(name = "card-number")
    @Description("The obscured card number associated with the purchase")
    @Size(max = 25)
    String cardNumber;

    @XmlElement
    String cardName;

    @XmlElement
    @Description("Amount paid in this payment")
    BigDecimal amount;

    @XmlElement(name = "currency-code")
    @Size(max = 3)
    @Description("Currency of the payment, ISO4217. Example: NOK")
    String currencyCode;

    @XmlElement(name = "foreign-currency-payment")
    ForeignCurrencyPayment foreignCurrencyPayment;

    public static final Payment EXAMPLE = new Payment("Bank Axept", "************1234", "Visa", new BigDecimal("100.0"), "NOK", ForeignCurrencyPayment.EXAMPLE);
}
