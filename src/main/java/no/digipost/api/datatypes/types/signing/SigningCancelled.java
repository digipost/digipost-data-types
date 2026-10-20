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

@XmlRootElement(name = "signing-cancelled")
@Value
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@With
@Description("Signals that the sender has cancelled the signing request. No further signing is possible.")
public class SigningCancelled implements DataType {

    @XmlElement(name = "digipostadresse", required = true)
    @Description("Digipost address for the sender who cancelled the signing request.")
    @NotBlank
    String digipostadresse;

    public static final SigningCancelled EXAMPLE = new SigningCancelled("ola.nordmann#1234");
}
