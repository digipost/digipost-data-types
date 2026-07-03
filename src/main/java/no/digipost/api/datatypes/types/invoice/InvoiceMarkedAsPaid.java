package no.digipost.api.datatypes.types.invoice;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@XmlRootElement(name = "invoice-marked-as-paid")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Marker that an invoice has been manually marked as paid")
public class InvoiceMarkedAsPaid implements DataType {

    @XmlElement(required = true, name = "marked-at")
    @Description("When the invoice was marked as paid")
    ZonedDateTime markedAt;

    public static final InvoiceMarkedAsPaid EXAMPLE = new InvoiceMarkedAsPaid(
            ZonedDateTime.of(2024, 1, 15, 12, 0, 0, 0, ZoneId.of("+01:00"))
    );
}
