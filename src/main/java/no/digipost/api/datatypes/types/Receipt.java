package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Receipt represents a documents containing details about a purchase")
public class Receipt implements DataType {


    @XmlElement(required = true)
    @NotNull
    @Description("When the purchase was made. ISO8601 full DateTime")
    ZonedDateTime time;

    @XmlElement(required = true)
    @NotNull
    @Description("The total price paid for the item(s) purchased")
    BigDecimal price;

    @XmlElement(name = "currency")
    @Size(max = 3)
    @Description("Currency of the price, ISO4217. Example: NOK")
    String currencyCode;

    @XmlElement(name = "sales-point", required = true)
    @NotNull
    @Size(max = 150)
    @Description("Name of the sales point. Example: Oslo City Røntgen")
    String salesPoint;

    @XmlElement
    @Description("The name of the chain the sales point is a member of. Example: Røntgen Labs AS")
    @Size(max = 150)
    String chain;

    public static Receipt EXAMPLE = new Receipt(
        ZonedDateTime.of(2017, 6, 27, 10, 0, 0, 0, ZoneId.systemDefault()),
        BigDecimal.valueOf(42000, 2),
        "NOK",
        "Oslo City Røntgen",
        "Røntgen Labs AS");
}
