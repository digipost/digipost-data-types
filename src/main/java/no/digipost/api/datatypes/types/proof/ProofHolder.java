package no.digipost.api.datatypes.types.proof;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class ProofHolder {
    @XmlElement(name = "firstname", required = true)
    @NotNull
    @Description("")
    String firstName;

    @XmlElement(name = "surname", required = true)
    @NotNull
    @Description("")
    String surname;

    @XmlElement(name = "social-security-number")
    @Pattern(regexp = "[0-9]{11}")
    @Description("")
    String socialSecurityNumber;

    @XmlElement(name = "address")
    @Description("")
    Address address;

    public static ProofHolder EXAMPLE = new ProofHolder("Ola", "Nordmann", null, Address.EXAMPLE);
}
