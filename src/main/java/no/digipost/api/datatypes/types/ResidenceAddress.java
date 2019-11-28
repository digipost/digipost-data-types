package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@Wither
public class ResidenceAddress {

    public ResidenceAddress(String houseNumber, String streetName, String postalCode, String city) {
        this(null, houseNumber, streetName, postalCode, city);
    }

    @XmlElement(name = "unit-number")
    @Size(max = 5)
    @Pattern(regexp = "^[UKHL]\\d{4}$", message = "must be of format [UKHL]0000. E.g. H0304")
    @Description("Bolignummer. Must be of format [UKHL]0000. E.g. H0304")
    String unitNumber;

    @XmlElement(name = "house-number")
    @Size(max = 20)
    @Description("A house number with or without a house letter. E.g. 11 or 11A")
    String houseNumber;

    @XmlElement(name = "street-name")
    @Size(max = 100)
    @Description("The name of the street. E.g. Storgata")
    String streetName;

    @XmlElement(name = "postal-code")
    @Size(max = 10)
    String postalCode;

    @XmlElement
    @Size(max = 100)
    String city;

    public static final ResidenceAddress EXAMPLE = new ResidenceAddress("23","Storgata", "0011", "Oslo");
}
