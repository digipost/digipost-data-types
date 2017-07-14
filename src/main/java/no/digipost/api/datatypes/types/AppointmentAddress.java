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
public class AppointmentAddress {

    public AppointmentAddress(String streetAddress, String postalCode, String city) {
        if (!Pattern.matches("\\d{4}", postalCode)) {
            throw new IllegalArgumentException("Postal code must be 4 digits");
        }

        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    @XmlElement(name = "street-address")
    @Size(max = 100)
    @Description("E.g. Storgata 11")
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
