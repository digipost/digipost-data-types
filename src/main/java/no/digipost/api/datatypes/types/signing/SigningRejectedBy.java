package no.digipost.api.datatypes.types.signing;

import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.With;
import no.digipost.api.datatypes.DataType;
import no.digipost.api.datatypes.documentation.Description;

@XmlRootElement(name = "signing-rejected-by")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Signals that one signer has rejected the signing request.")
public class SigningRejectedBy implements DataType {

    @XmlElement(name = "digipostadresse", required = true)
    @Description("Digipost address for the signer who rejected signing.")
    @NotBlank
    String digipostadresse;

    public static final SigningRejectedBy EXAMPLE = new SigningRejectedBy("kari.nordmann#1234");
}

