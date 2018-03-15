package no.digipost.api.datatypes.types.receipt;

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
    public static final String CODE_128 = "code-128";

    @XmlElement(name = "barcode-value")
    @Description("The barcode on this receipt")
    String barcodeValue;

    @XmlElement(name = "barcode-type")
    String barcodeType;

    public static Barcode EXAMPLE = new Barcode("1234567890", CODE_128);
}
