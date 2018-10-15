package no.digipost.api.datatypes.types.pickup;

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
public class Customs {

    @XmlElement(name = "value", required = true)
    @Description("The value of the parcel in NOK")
    BigDecimal value;
    
    @XmlElement(name = "payed-customs-fee", required = true)
    @Description("payed fee in customs")
    BigDecimal payedCustomsFee;
    
    @XmlElement(name = "vas-text", required = true)
    @Description("Text from custums")
    String vasText;

    public static final Customs EXAMPLE = new Customs(new BigDecimal("1277.00"), new BigDecimal("162.00"), "FORENKLET TOLLBEHANDLING");
    
}
