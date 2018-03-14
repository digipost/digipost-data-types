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
@Description("Payment in foreign currency with conversion")
public class ForeignCurrencyPayment {

    @XmlElement(name = "currency-code")
    @Size(max = 3)
    @Description("Currency of the payment, ISO4217. Example: NOK")
    String currencyCode;

    @XmlElement(name = "amount")
    BigDecimal amount;

    @XmlElement(name = "exchange-rate")
    BigDecimal exchangeRate;

    @XmlElement(name = "label")
    String label;

    public static ForeignCurrencyPayment EXAMPLE = new ForeignCurrencyPayment("USD", new BigDecimal("15"), new BigDecimal("7.534567"), null);
}
