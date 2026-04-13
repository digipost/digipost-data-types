package no.digipost.api.datatypes.types.signing;

import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.documentation.Description;

@XmlType
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
public class Signatar {

    @XmlElement(name = "digipostadresse", required = true)
    @Description("Digipost address of the signer.")
    @NotBlank
    String digipostadresse;

    @XmlElement(name = "navn")
    @Description("Full name of the signer.")
    String navn;

    public static final Signatar EXAMPLE = new Signatar("ola.nordmann#1234", "Ola Nordmann");
}

