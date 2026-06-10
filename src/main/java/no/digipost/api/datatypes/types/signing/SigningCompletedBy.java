package no.digipost.api.datatypes.types.signing;

import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.ComplementedBy;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "signing-completed-by")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Signals that one signer has completed signing.")
@ComplementedBy(SigningCompletedBy.class)
public class SigningCompletedBy implements DataType {

    @XmlElement(name = "digipostadresse", required = true)
    @Description("Digipost address for the signer who completed signing.")
    @NotBlank
    String digipostadresse;

    public static final SigningCompletedBy EXAMPLE = new SigningCompletedBy("ola.nordmann#1234");
}

