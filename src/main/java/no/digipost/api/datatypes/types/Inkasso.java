package no.digipost.api.datatypes.types;

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
import no.digipost.api.datatypes.types.invoice.InvoicePayment;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("A debt collection payment")
@ComplementedBy({InvoicePayment.class})
public class Inkasso implements DataType {
    @XmlElement
    @Description("A link to more information, or further actions that can be taken")
    ExternalLink link;
    @XmlElement(required = true, name = "due-date")
    @Description("When the payment falls due")
    ZonedDateTime dueDate;
    @XmlElement
    @Description("The sum to be payed")
    BigDecimal sum;
    @XmlElement
    @Description("The creditor account for the payment. Exactly 11 digits")
    @Size(min = 11, max = 11)
    String account;
    @XmlElement
    @Description("The customer identification number. Max length 25 chars")
    @Size(max = 25)
    String kid;

    public static Inkasso EXAMPLE = new Inkasso(
            ExternalLink.EXAMPLE_NO_DEADLINE
            , ZonedDateTime.of(2019, 12, 10, 0, 0, 0, 0, ZoneId.of("+01:00"))
            , BigDecimal.valueOf(42), "01235424320", "1435025439583420243982723"
    );

}
