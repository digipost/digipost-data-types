package no.digipost.api.datatypes.types.invoice;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement(name = "invoice-payment")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Payment information for an invoice")
@ComplementedBy({InvoicePayment.class})
public class InvoicePayment implements DataType {

    @XmlElement(required = true, name = "payment-id")
    @Description("Unique id to reference the payment with third party")
    String paymentId;

    @XmlElement(required = true, name = "payment-status")
    @Description("A status a given payment is in. ISO20022 payment statuses can be used")
    String paymentStatus;

    @XmlElement(required = true, name = "payment-time")
    @Description("When the payment is done")
    ZonedDateTime paymentTime;

    @XmlElement(required = true, name = "debtor-account")
    @Description("The debtor account for the payment. Exactly 11 digits")
    @Size(min = 11, max = 11)
    String debtorAccount;

    @XmlElement(name = "debtor-account-name")
    @Description("Optional name of the account")
    String debtorAccountName;

    @XmlElement(required = true, name = "payment-channel")
    @Description("Name the third party performing the payment")
    String paymentChannel;

    @XmlElement(required = true, name = "payment-bank")
    @Description("The bank payment is registered with")
    @NotNull
    Bank paymentBank;

    public static final InvoicePayment EXAMPLE = new InvoicePayment(
            "33aa4572ac1c61d807345c5968ab1fbd"
            , "PDNG"
            , ZonedDateTime.of(2020, 9, 21, 0, 0, 0, 0, ZoneId.of("+01:00"))
            , "01235424320"
            , null
            , "My pay app"
            , Bank.EXAMPLE
    );
}
