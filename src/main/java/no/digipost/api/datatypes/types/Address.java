package no.digipost.api.datatypes.types;

import lombok.*;
import lombok.experimental.FieldDefaults;
import no.digipost.api.datatypes.documentation.Description;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.regex.Pattern;

@XmlType
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Address {


    public Address(String streetAddress, String postalCode, String city) {
        this(null, null, streetAddress, postalCode, city);
    }

    public Address(String dwellingNumber, String houseNumber, String streetAddress, String postalCode, String city) {
        if (dwellingNumber != null && houseNumber != null) {
            throw new IllegalArgumentException("An address can not both have a dwelling number and a house number.");
        }
        if (dwellingNumber != null && !Pattern.matches("[UKHL]\\d{4}", dwellingNumber)) {
            throw new IllegalArgumentException("Dwelling number must be of format [UKHL]0000");
        }
        if (houseNumber != null && !Pattern.matches("[A-Z]", houseNumber)) {
            throw new IllegalArgumentException("House number must be a uppercase letter between A and Z");
        }

        if (!Pattern.matches("\\d{4}", postalCode)) {
            throw new IllegalArgumentException("Postal code must be 4 digits");
        }

        this.dwellingNumber = dwellingNumber;
        this.houseNumber = houseNumber;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    @XmlElement(name = "dwelling-number")
    @Size(max = 5)
    @Description("Bolignummer. Must be of format [UKHL]0000. Ex H0304")
    String dwellingNumber;

    @XmlElement(name = "house-number")
    @Size(max = 1)
    @Description("The house number. One uppercase letter. Ex A")
    String houseNumber;

    @XmlElement(name = "street-address", required = true)
    @Size(max = 100)
    String streetAddress;

    @XmlElement(name = "postal-code", required = true)
    @NotNull
    @Size(max = 10)
    String postalCode;

    @XmlElement(required = true)
    @NotNull
    @Size(max = 100)
    String city;
}
