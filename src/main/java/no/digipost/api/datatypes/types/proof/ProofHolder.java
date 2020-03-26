package no.digipost.api.datatypes.types.proof;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;
import no.digipost.api.datatypes.types.Address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

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
