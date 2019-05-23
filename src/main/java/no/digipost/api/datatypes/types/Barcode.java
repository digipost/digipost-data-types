package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.Size;
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
    @Size(max = 20)
    String barcodeValue;

    @XmlElement(name = "barcode-type")
    @Size(max = 12)
    String barcodeType;

    @XmlElement(name = "barcode-text")
    @Description("Barcode text can be used to describe the barcode")
    String barcodeText;

    @XmlElement(name = "show-value-in-barcode", defaultValue = "false")
    @Description("If true, the barcode will render its value as part of the image")
    Boolean showValueInBarcode;

    public Barcode(@Size(max = 20) String barcodeValue, @Size(max = 12) String barcodeType) {
        this.barcodeValue = barcodeValue;
        this.barcodeType = barcodeType;
        barcodeText = null;
        showValueInBarcode = false;
    }

    public static Barcode EXAMPLE = new Barcode("1234567890", CODE_128, "Show barcode for faster identification", true);
}
