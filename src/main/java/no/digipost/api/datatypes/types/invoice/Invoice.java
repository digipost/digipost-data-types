package no.digipost.api.datatypes.types.invoice;

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
import no.digipost.api.datatypes.types.ExternalLink;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement(name = "invoice")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("An invoice")
@ComplementedBy({InvoicePayment.class})
public class Invoice implements DataType {

    @XmlElement
    @Description("A link to more information, or further actions that can be taken")
    ExternalLink link;

    @XmlElement(required = true, name = "due-date")
    @Description("When the payment falls due")
    ZonedDateTime dueDate;

    @XmlElement(required = true, name = "sum")
    @Description("The sum to be paid")
    BigDecimal sum;

    @XmlElement(required = true, name = "creditor-account")
    @Description("The creditor account for the payment. Exactly 11 digits")
    @Size(min = 11, max = 11)
    String creditorAccount;

    @XmlElement
    @Description("The customer identification number. Max length 25 chars")
    @Size(max = 25)
    String kid;

    public static final Invoice EXAMPLE = new Invoice(
            ExternalLink.EXAMPLE_NO_DEADLINE
            , ZonedDateTime.of(2020, 9, 10, 0, 0, 0, 0, ZoneId.of("+01:00"))
            , BigDecimal.valueOf(42)
            , "01235424320"
            , "1435025439583420243982723"
    );
}
