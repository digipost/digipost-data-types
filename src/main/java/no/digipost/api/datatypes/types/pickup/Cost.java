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
public class Cost {

    @XmlElement(name = "value-to-be-payed", required = true)
    @Description("The value of the parcel in NOK")
    BigDecimal valueToBePayed;

    @XmlElement(name = "package-value")
    @Description("The value of the parcel in NOK")
    BigDecimal packageValue;
    
    @XmlElement(name = "customs-fee-outlayed")
    @Description("payed fee in customs")
    BigDecimal customsFeeOutlayed;
    
    @XmlElement(name = "vas-text")
    @Description("Information about the value added service (vas)")
    String vasText;
    
    @XmlElement(name = "customs-fee")
    @Description("Fee payed for customs declaration")
    BigDecimal customsFee;
    
    @XmlElement(name = "customs-fee-outlay-cost")
    @Description("Outlay for customs by the service")
    BigDecimal customsFeeOutlayCost;
    
    @XmlElement(name = "cod-amount")
    @Description("Cash on delivery (cod) amount")
    BigDecimal codAmount;
    
    @XmlElement(name = "cod-fee")
    @Description("Cash on delivery (cod) fee")
    BigDecimal codFee;
    

    public static final Cost EXAMPLE = new Cost(
            new BigDecimal("128.00"), 
            new BigDecimal("1277.00"), 
            new BigDecimal("162.00"), 
            "FORENKLET TOLLBEHANDLING",
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO,
            BigDecimal.ZERO
    );
    
}
