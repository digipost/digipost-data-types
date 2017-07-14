package no.digipost.api.datatypes.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.regex.Pattern;

@XmlType
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ResidenceAddress {

    public ResidenceAddress(String houseNumber, String streetName, String postalCode, String city) {
        this(null, houseNumber, streetName, postalCode, city);
    }

    public ResidenceAddress(String unitNumber, String houseNumber, String streetName, String postalCode, String city) {
        if (!Pattern.matches("\\d{4}", postalCode)) {
            throw new IllegalArgumentException("Postal code must be 4 digits");
        }

        if (unitNumber != null && !Pattern.matches("^[KUHL]\\d{4}$", unitNumber)) {
            throw new IllegalArgumentException("Illegal unit number. Please see description for this field.");
        }

        if (houseNumber != null && !Pattern.matches("^\\d+[A-Z]*$", houseNumber)) {
            throw new IllegalArgumentException("Illegal house number. Please see description for this field.");
        }

        if (! Pattern.matches("^[a-zA-ZæøåÆØÅ\\s]+$", streetName)) {
            throw new IllegalArgumentException("Illegal Streetname. Can only contain letters and spaces");
        }

        this.unitNumber = unitNumber;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }


    @XmlElement(name = "unit-number")
    @Size(max = 5)
    @Description("Bolignummer. Must be of format [UKHL]0000. E.g. H0304")
    String unitNumber;

    @XmlElement(name = "house-number")
    @Size(max = 5)
    @Description("A house number with or without a house letter. E.g. 11 or 11A")
    String houseNumber;

    @XmlElement(name = "street-name", required = true)
    @NotNull
    @Size(max = 100)
    @Description("The name of the street. E.g. Storgata")
    String streetName;

    @XmlElement(name = "postal-code", required = true)
    @NotNull
    @Size(max = 10)
    String postalCode;

    @XmlElement(required = true)
    @NotNull
    @Size(max = 100)
    String city;
}
