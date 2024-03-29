package no.digipost.api.datatypes.types.receipt;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;
import no.digipost.api.datatypes.types.Barcode;
import no.digipost.api.datatypes.types.Language;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Collections.singletonList;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Receipt represents a document containing details about a purchase")
public class Receipt implements DataType {

    @XmlElement
    @Description("The ID of this receipt in the system it was imported from")
    @Size(max = 50)
    String receiptId;

    @XmlElement
    @Description("The original receipt number from the store")
    String receiptNumber;

    @XmlElement(required = true)
    @NotNull
    @Description("When the purchase was made. ISO8601 full DateTime")
    ZonedDateTime purchaseTime;

    @XmlElement(required = true)
    @NotNull
    @Description("The total price paid for the item(s) purchased")
    BigDecimal totalPrice;

    @NotNull
    @XmlElement(required = true)
    @Description("The total vat amount for the item(s) purchased")
    BigDecimal totalVat;

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

    @XmlElement(name = "merchant-chain")
    @Description("Optional name of the chain that the merchant is a part of")
    String merchantChain;

    @XmlElement(name = "merchant-name", required = true)
    @NotNull
    @Size(max = 150)
    @Description("Name of the store or merchant. Example: Grünerløkka Hip Coffee")
    String merchantName;

    @XmlElement(name = "merchant-phone-number")
    String merchantPhoneNumber;

    @XmlElement(name = "merchant-address")
    @Description("Address of the store or merchant")
    @Valid
    Address merchantAddress;

    @XmlElement(name = "orgnumber")
    @Description("Organization number of the sales point")
    String organizationNumber;

    @XmlElement
    Barcode barcode;

    @XmlElement
    @Description("List of payments done during this purchase")
    @Valid
    List<Payment> payments;

    @XmlElement
    @Description("The individual items sold")
    @Valid
    List<ReceiptLine> items;

    @XmlElement
    @Description("Details for taxi receipts")
    @Valid
    TaxiDetails taxiDetails;

    @XmlElement
    @Description("Name and address of customer")
    Customer customer;

    @XmlElement
    @Description("Name and address of delivery")
    Delivery delivery;

    @XmlElement(name = "order-number")
    String orderNumber;

    @XmlElement(name = "membership-number")
    String membershipNumber;

    @XmlElement
    String comment;

    @XmlElement(defaultValue = "NB")
    @Description("Languange for the document")
    Language language;

    public static Receipt EXAMPLE = new Receipt(
            "F96B6805-2453-478A-B58B-CCDFA07E21ED"
            , "364567"
            , ZonedDateTime.of(2018, 5, 27, 10, 0, 0, 0, ZoneId.of("+02:00"))
            , ReceiptLine.EXAMPLE.getTotalPrice()
            , ReceiptLine.EXAMPLE.getTotalVat()
            , "NOK"
            , "Benny"
            , "15"
            , "7F5A1EFF-ECAE-48A7-A07F-38D87576F815"
            , "Grünerløkka Hip Coffee", "12345678"
            , Address.EXAMPLE
            , "123456789"
            , Barcode.EXAMPLE
            , singletonList(Payment.EXAMPLE)
            , singletonList(ReceiptLine.EXAMPLE)
            , TaxiDetails.EXAMPLE
            , Customer.EXAMPLE
            , Delivery.EXAMPLE
            , "123456"
            , "HG1234HH8778"
            , "Hip Coffee to the good citizens of Løkka"
            , Language.NB
    );

}
