package no.digipost.api.datatypes.types.openingreceipt;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "opening-receipt-accepted")
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@With
@Description("The document has been opened, and the opening receipt has been accepted and sent.")
public class OpeningReceiptAccepted implements DataType {

    public static final OpeningReceiptAccepted EXAMPLE = new OpeningReceiptAccepted();

}
