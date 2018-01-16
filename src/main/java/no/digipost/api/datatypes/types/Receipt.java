package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Collections.singletonList;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
@Description("Receipt represents a document containing details about a purchase")
public class Receipt implements DataType {


    @XmlElement(required = true)
    @NotNull
    @Description("When the purchase was made. ISO8601 full DateTime")
    ZonedDateTime time;

    @XmlElement(required = true)
    @NotNull
    @Description("The total net price paid for the item(s) purchased")
    BigDecimal price;

    @XmlElement(name = "currency")
    @Size(max = 3)
    @Description("Currency of the price, ISO4217. Example: NOK")
    String currencyCode;

    @XmlElement
    @Description("Identifier for cashier who made the sale")
    @Size(max = 100)
    String cashier;

    @XmlElement
    @Description("Identifier for the register where the purchase was made")
    @Size(max = 50)
    String register;

    @XmlElement(name = "sales-point", required = true)
    @NotNull
    @Size(max = 150)
    @Description("Name of the sales point. Example: Grünerløkka Hip Coffee")
    String salesPoint;

    @XmlElement
    @Description("The name of the chain the sales point is a member of. Example: Hip Coffee inc")
    @Size(max = 150)
    String chain;

    @XmlElement
    @Description("The ID of this receipt in the system it was imported from")
    @Size(max = 50)
    String externalId;

    @XmlElement
    @Description("The barcode on this receipt")
    @Digits(integer = 50, fraction = 0)
    String barcode;

    @XmlElement
    @Description("Address of the sales point")
    @Valid
    AppointmentAddress address;

    @XmlElement(name = "orgnumber")
    @Description("Organization number of the sales point")
    @Digits(integer = 9, fraction = 0)
    String organizationNumber;

    @XmlElement
    @Description("List of payments done during this purchase")
    @Valid
    List<Payment> payments;

    @XmlElement
    @Description("The individual items sold")
    @Valid
    List<ReceiptItem> items;

    public static Receipt EXAMPLE = new Receipt(
        ZonedDateTime.of(2017, 10, 27, 10, 0, 0, 0, ZoneId.systemDefault()),
        BigDecimal.valueOf(14200, 2),
            "NOK", "Benny", "15",
            "Grünerløkka Hip Coffee",
            "Hip Coffee inc", "12340112331", "12340112331", AppointmentAddress.EXAMPLE,
            "010234563", singletonList(Payment.EXAMPLE), singletonList(ReceiptItem.EXAMPLE));
}
