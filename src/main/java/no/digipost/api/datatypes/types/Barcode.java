package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class Barcode {
    @XmlElement(name = "barcode-value")
    @Description("The barcode on this receipt")
    String barcodeValue;

    @XmlElement(name = "barcode-type")
    String barcodeType;

    @XmlElement(name = "barcode-display-value")
    String barcodeDisplayValue;

    public static Barcode EXAMPLE = new Barcode("1234567890", "1D", "1234567890");
}
