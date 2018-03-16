package no.digipost.api.datatypes.types.receipt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Card {
    @XmlElement(name="card-number")
    @Description("Card or account number")
    String cardNumber;
    @XmlElement
    @Description("BankAxept, MasterCard, VISA, etc.")
    String type;

    public static final Card EXAMPLE = new Card("12345678900", "BankAxept");
}
